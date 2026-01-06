package com.wellpath.er.feature.exercises.cbt.viewmodel

import androidx.lifecycle.ViewModel
import com.wellpath.er.data.assignments.model.Assignment
import com.wellpath.er.data.journal.model.Month
import com.wellpath.er.data.journal.repository.JournalRepository
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class CbtViewModel(
    val journalRepository: JournalRepository
) : ViewModel() {

    @OptIn(ExperimentalTime::class)
    fun finishCbtExercise() {
        val currentDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val journalRecordId = "${currentDate.day}${currentDate.month}${currentDate.year}"
        journalRepository.addAssignment(
            journalRecordId = journalRecordId,
            assignment = Assignment(
                type = Assignment.Type.EXERCISE_CBT,
                isCompleted = true,
                day = currentDate.day,
                month = Month.getById(currentDate.month.ordinal),
                year = currentDate.year
            )
        )
    }
}