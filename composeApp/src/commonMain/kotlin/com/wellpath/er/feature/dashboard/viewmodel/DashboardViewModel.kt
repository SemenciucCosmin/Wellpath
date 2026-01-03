package com.wellpath.er.feature.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wellpath.er.data.journal.repository.JournalRepository
import com.wellpath.er.data.patient.repository.PatientRepository
import com.wellpath.er.domain.extensions.BLANK
import com.wellpath.er.feature.dashboard.viewmodel.model.DashboardUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class DashboardViewModel(
    private val journalRepository: JournalRepository,
    private val patientRepository: PatientRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadAssignments()
        loadPatient()
    }

    @OptIn(ExperimentalTime::class)
    private fun loadAssignments() {
        viewModelScope.launch {
            val currentDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            val journalRecordId = "${currentDate.day}${currentDate.month}${currentDate.year}"
            journalRepository.getJournalRecord(journalRecordId).filterNotNull().collectLatest {
                _uiState.update { state ->
                    state.copy(assignments = it.assignments)
                }
            }
        }
    }

    private fun loadPatient() {
        viewModelScope.launch {
            patientRepository.getCurrentPatient().collectLatest { selectedPatient ->
                _uiState.update {
                    it.copy(selectedPatientName = selectedPatient?.name ?: String.BLANK)
                }
            }
        }
    }
}
