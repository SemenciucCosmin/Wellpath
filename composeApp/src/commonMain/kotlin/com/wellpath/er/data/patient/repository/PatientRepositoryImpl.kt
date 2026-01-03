package com.wellpath.er.data.patient.repository

import com.wellpath.er.data.patient.model.Patient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update

class PatientRepositoryImpl : PatientRepository {

    private val selectedPatientId = MutableStateFlow(getMockedPatients().random().id)
    private val patients = MutableStateFlow(getMockedPatients())

    override fun getAllPatients(): Flow<List<Patient>> {
        return patients
    }

    override fun getCurrentPatient(): Flow<Patient?> {
        return combine(selectedPatientId, patients) { selectedPatientId, patients ->
            patients.firstOrNull { it.id == selectedPatientId }
        }
    }

    override fun selectPatient(patientId: Long) {
        selectedPatientId.update { patientId }
    }

    private fun getMockedPatients() = listOf(
        Patient(id = 1L, name = "Ion Popescu", age = 45, gender = "Male"),
        Patient(id = 2L, name = "Maria Ionescu", age = 32, gender = "Female"),
        Patient(id = 3L, name = "Andrei Dumitru", age = 28, gender = "Male"),
        Patient(id = 4L, name = "Elena Marinescu", age = 54, gender = "Female"),
        Patient(id = 5L, name = "Vlad Georgescu", age = 39, gender = "Male")
    )
}