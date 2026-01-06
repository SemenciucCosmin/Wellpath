package com.wellpath.er.feature.exercises.cbt.route

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.wellpath.er.feature.exercises.cbt.model.CbtStage
import com.wellpath.er.feature.exercises.cbt.viewmodel.CbtViewModel
import com.wellpath.er.ui.components.PrimaryButton
import com.wellpath.er.ui.navigation.model.ExercisesNavDestination
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_cbt_finish_title
import wellpath.composeapp.generated.resources.lbl_finish

@Composable
fun CbtFinishRoute(navController: NavController) {
    val viewModel: CbtViewModel = koinViewModel()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(Pds.spacing.Medium)
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(Res.string.lbl_cbt_finish_title),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.weight(1f))

            PrimaryButton(
                text = stringResource(Res.string.lbl_finish),
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.finishCbtExercise()
                    navController.popBackStack(
                        route = ExercisesNavDestination.CBT(CbtStage.SITUATION.id),
                        inclusive = true
                    )
                }
            )
        }
    }
}