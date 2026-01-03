package com.wellpath.er.feature.exercises.exercises.di

import com.wellpath.er.feature.exercises.exercises.viewmodel.ExercisesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun exercisesFeatureModule() = module {
    viewModelOf(::ExercisesViewModel)
}