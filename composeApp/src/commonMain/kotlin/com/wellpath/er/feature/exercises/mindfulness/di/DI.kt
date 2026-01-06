package com.wellpath.er.feature.exercises.mindfulness.di

import com.wellpath.er.feature.exercises.mindfulness.viewmodel.MindfulnessViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun mindfulnessFeatureModule() = module {
    viewModelOf(::MindfulnessViewModel)
}