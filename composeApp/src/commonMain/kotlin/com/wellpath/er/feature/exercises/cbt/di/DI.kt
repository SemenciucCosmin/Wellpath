package com.wellpath.er.feature.exercises.cbt.di

import com.wellpath.er.feature.exercises.cbt.viewmodel.CbtViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun cbtFeatureModule() = module {
    viewModelOf(::CbtViewModel)
}