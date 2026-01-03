package com.wellpath.er.feature.exercises.breathing.route

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.wellpath.er.domain.extensions.getContext
import com.wellpath.er.domain.extensions.showToast
import com.wellpath.er.domain.model.ToastLength
import com.wellpath.er.feature.exercises.breathing.model.BreathingStage
import com.wellpath.er.feature.exercises.breathing.viewmodel.BreathingViewModel
import com.wellpath.er.feature.exercises.breathing.viewmodel.model.BreathingUiState
import com.wellpath.er.ui.components.EventHandler
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_exercise_finish_message
import wellpath.composeapp.generated.resources.lbl_exercise_saved_successfully
import wellpath.composeapp.generated.resources.lbl_save

@Composable
fun BreathingRoute(navController: NavController) {
    val viewModel: BreathingViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var currentStage by remember { mutableStateOf(BreathingStage.READY) }
    val haptic = LocalHapticFeedback.current

    Scaffold { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                Pds.spacing.Medium,
                Alignment.CenterVertically
            ),
            modifier = Modifier
                .padding(paddingValues)
                .padding(Pds.spacing.Medium)
                .fillMaxSize()
        ) {
            BreathingBubbleButton(
                currentStage = currentStage,
                onStageChange = {
                    if (currentStage == BreathingStage.READY && it != BreathingStage.READY) {
                        viewModel.markExerciseStart()
                    }

                    if (it == BreathingStage.FINISHED) {
                        viewModel.markExerciseEnd()
                    }

                    currentStage = it
                    haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                }
            )

            Text(
                text = stringResource(currentStage.indicatorLabelRes),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            AnimatedVisibility(currentStage == BreathingStage.FINISHED) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        Pds.spacing.Medium,
                        Alignment.CenterVertically
                    )
                ) {
                    Text(
                        text = stringResource(
                            Res.string.lbl_exercise_finish_message,
                            uiState.elapsedTime
                        ),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    FilledTonalButton(
                        onClick = viewModel::saveExercise
                    ) {
                        Text(text = stringResource(Res.string.lbl_save))
                    }
                }
            }
        }
    }

    EventHandler(viewModel.events) { event ->
        when (event) {
            BreathingUiState.BreathingEvent.SAVE_SUCCESSFUL -> {
                navController.navigateUp()
                showToast(
                    context = getContext(),
                    message = stringResource(Res.string.lbl_exercise_saved_successfully),
                    length = ToastLength.SHORT
                )
            }
        }
    }
}