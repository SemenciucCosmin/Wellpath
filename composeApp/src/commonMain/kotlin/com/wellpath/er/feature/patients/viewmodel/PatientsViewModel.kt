package com.wellpath.er.feature.patients.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wellpath.er.data.patient.repository.PatientRepository
import com.wellpath.er.feature.patients.viewmodel.model.PatientsUiState
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PatientsViewModel(
    private val patientRepository: PatientRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(PatientsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadPatients()
        loadPatient()
    }

    private fun loadPatients() {
        viewModelScope.launch {
            patientRepository.getAllPatients().collectLatest { patients ->
                _uiState.update { it.copy(patients = patients.toImmutableList()) }
            }
        }
    }

    private fun loadPatient() {
        viewModelScope.launch {
            patientRepository.getCurrentPatient().collectLatest { patient ->
                _uiState.update { it.copy(selectedPatientId = patient?.id) }
            }
        }
    }

    fun selectPatient(patientId: Long) {
        patientRepository.selectPatient(patientId)
    }
}