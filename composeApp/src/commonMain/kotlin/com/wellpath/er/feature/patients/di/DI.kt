package com.wellpath.er.feature.patients.di

import com.wellpath.er.feature.patients.viewmodel.PatientsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun patientsFeatureModule() = module {
    viewModelOf(::PatientsViewModel)
}