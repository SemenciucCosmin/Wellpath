package com.wellpath.er.feature.exercises.breathing.viewmodel

import com.wellpath.er.feature.exercises.breathing.viewmodel.model.BreathingUiState
import com.wellpath.er.ui.viewmodel.EventViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class BreathingViewModel : EventViewModel<BreathingUiState.BreathingEvent>() {

    private val _uiState = MutableStateFlow(BreathingUiState())
    val uiState = _uiState.asStateFlow()

    @OptIn(ExperimentalTime::class)
    fun markExerciseStart() {
        _uiState.update {
            it.copy(
                startingMillis = Clock.System.now().toEpochMilliseconds(),
                endingMillis = null
            )
        }
    }

    @OptIn(ExperimentalTime::class)
    fun markExerciseEnd() {
        _uiState.update {
            it.copy(endingMillis = Clock.System.now().toEpochMilliseconds())
        }
    }

    fun saveExercise() {
        registerEvent(BreathingUiState.BreathingEvent.SAVE_SUCCESSFUL)
    }
}
