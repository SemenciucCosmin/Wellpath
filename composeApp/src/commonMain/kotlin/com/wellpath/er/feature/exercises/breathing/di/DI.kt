package com.wellpath.er.feature.exercises.breathing.di

import com.wellpath.er.feature.exercises.breathing.viewmodel.BreathingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun breathingFeatureModule() = module {
    viewModelOf(::BreathingViewModel)
}