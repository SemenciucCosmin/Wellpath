package com.wellpath.er.data.patient.di

import com.wellpath.er.data.patient.repository.PatientRepository
import com.wellpath.er.data.patient.repository.PatientRepositoryImpl
import org.koin.dsl.module

fun patientDataModule() = module {
    single<PatientRepository> { PatientRepositoryImpl() }
}