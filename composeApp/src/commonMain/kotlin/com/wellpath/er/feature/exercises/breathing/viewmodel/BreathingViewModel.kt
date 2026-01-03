package com.wellpath.er.feature.exercises.breathing.viewmodel

import com.wellpath.er.data.assignments.model.Assignment
import com.wellpath.er.data.journal.model.Month
import com.wellpath.er.data.journal.repository.JournalRepository
import com.wellpath.er.feature.exercises.breathing.viewmodel.model.BreathingUiState
import com.wellpath.er.ui.viewmodel.EventViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class BreathingViewModel(
    private val journalRepository: JournalRepository
) : EventViewModel<BreathingUiState.BreathingEvent>() {

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

    @OptIn(ExperimentalTime::class)
    fun saveExercise() {
        val currentDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val journalRecordId = "${currentDate.day}${currentDate.month}${currentDate.year}"
        journalRepository.addAssignment(
            journalRecordId = journalRecordId,
            assignment = Assignment(
                type = Assignment.Type.EXERCISE_BREATHING,
                isCompleted = true,
                day = currentDate.day,
                month = Month.getById(currentDate.month.ordinal),
                year = currentDate.year
            )
        )

        registerEvent(BreathingUiState.BreathingEvent.SAVE_SUCCESSFUL)
    }
}
