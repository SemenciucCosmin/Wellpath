package com.wellpath.er.feature.test.route

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.wellpath.er.feature.test.component.TestScreen
import com.wellpath.er.feature.test.di.TestScope
import com.wellpath.er.feature.test.viewmodel.TestViewModel
import com.wellpath.er.feature.test.viewmodel.model.TestUiState
import com.wellpath.er.ui.components.EventHandler
import com.wellpath.er.ui.navigation.model.TestNavDestination
import com.wellpath.er.ui.theme.Pds
import org.koin.compose.getKoin

/**
 * Route for form onboarding flow
 */
@Composable
fun TestRoute(
    index: Int,
    navController: NavController,
) {
    val koin = getKoin()
    val viewModel = koin.getScope(TestScope.ID).get<TestViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val questions = uiState.bfiPages.getOrNull(index) ?: return
    val responsesCount = uiState.responses.filter { (questionId, _) ->
        questionId in questions.map { it.id }
    }.size

    TestScreen(
        pageCount = uiState.bfiPages.size,
        selectedPageIndex = index,
        questions = questions,
        responses = uiState.responses,
        isNextButtonEnabled = responsesCount == questions.size,
        onResponseClick = viewModel::registerResponse,
        onNextClick = viewModel::finishForm,
        onBack = navController::navigateUp,
        modifier = Modifier.padding(
            top = Pds.spacing.XXLarge,
            bottom = Pds.spacing.Large,
            start = Pds.spacing.Large,
            end = Pds.spacing.Large,
        )
    )

    EventHandler(viewModel.events) { event ->
        when (event) {
            TestUiState.TestEvent.NEXT_PAGE -> {
                val nextPageIndex = index + 1
                viewModel.unregisterEvent(event)
                navController.navigate(TestNavDestination.Test(nextPageIndex))
            }
            TestUiState.TestEvent.FINISH_FORM -> {
                viewModel.unregisterEvent(event)
                TestScope.delete(koin)
            }
        }
    }
}
