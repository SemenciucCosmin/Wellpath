package com.wellpath.er.feature.patients.viewmodel.model

import com.wellpath.er.data.patient.model.Patient
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class PatientsUiState(
    val patients: ImmutableList<Patient> = persistentListOf(),
    val selectedPatientId: Long? = null
)
