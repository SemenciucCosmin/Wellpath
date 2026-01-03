package com.wellpath.er.feature.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import com.wellpath.er.data.journal.repository.JournalRepository
import com.wellpath.er.feature.dashboard.viewmodel.model.DashboardUiState
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class DashboardViewModel(
    private val journalRepository: JournalRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadAssignments()
    }

    @OptIn(ExperimentalTime::class)
    private fun loadAssignments() {
        val currentDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val journalRecordId = "${currentDate.day}${currentDate.month}${currentDate.year}"
        val currentJournalRecord = journalRepository.getJournalRecord(journalRecordId)

        _uiState.update {
            it.copy(assignments = currentJournalRecord?.assignments ?: persistentListOf())
        }
    }
}
