package com.wellpath.er.data.patient.repository

import com.wellpath.er.data.patient.model.Patient
import kotlinx.coroutines.flow.Flow

interface PatientRepository {

    fun getAllPatients(): Flow<List<Patient>>

    fun getCurrentPatient(): Flow<Patient?>

    fun selectPatient(patientId: Long)
}