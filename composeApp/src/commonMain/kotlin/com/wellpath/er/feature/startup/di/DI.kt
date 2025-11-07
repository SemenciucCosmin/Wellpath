package com.wellpath.er.feature.startup.di

import com.wellpath.er.feature.startup.viewmodel.StartupViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun startupFeatureModule() = module {
    viewModelOf(::StartupViewModel)
}