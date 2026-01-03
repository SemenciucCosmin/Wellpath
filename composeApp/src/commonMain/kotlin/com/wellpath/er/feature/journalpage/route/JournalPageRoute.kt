package com.wellpath.er.feature.journalpage.route

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.wellpath.er.feature.journalpage.components.AssignmentItem
import com.wellpath.er.feature.journalpage.components.JournalPageForm
import com.wellpath.er.feature.journalpage.viewmodel.JournalPageViewModel
import com.wellpath.er.ui.components.TitleBar
import com.wellpath.er.ui.model.TitleBarMenuItem
import com.wellpath.er.ui.theme.Pds
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_left_arrow
import wellpath.composeapp.generated.resources.lbl_save

@Composable
fun JournalPageRoute(
    navController: NavController,
    journalRecordId: String,
    isReadOnly: Boolean,
) {
    val viewModel: JournalPageViewModel = koinViewModel(
        parameters = { parametersOf(journalRecordId) }
    )

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TitleBar(
                label = uiState.date,
                actionIcon = painterResource(Res.drawable.ic_left_arrow),
                onAction = navController::navigateUp,
                menuItems = listOfNotNull(
                    TitleBarMenuItem(
                        label = stringResource(Res.string.lbl_save),
                        action = {
                            viewModel.saveJournalPage()
                            navController.navigateUp()
                        },
                    ).takeIf { !isReadOnly }
                ).toImmutableList()
            )
        }
    ) { paddingValues ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Pds.spacing.Medium),
            modifier = Modifier
                .padding(paddingValues)
                .padding(Pds.spacing.Medium)
        ) {
            item {
                JournalPageForm(
                    moodScore = uiState.moodScore,
                    journalEntry = uiState.comment,
                    isReadOnly = isReadOnly,
                    onChangeMoodScore = viewModel::changeMoodScore,
                    onChangeJournalEntry = viewModel::changeComment
                )
            }

            items(uiState.assignments) { assignment ->
                AssignmentItem(assignment)
            }
        }
    }
}
