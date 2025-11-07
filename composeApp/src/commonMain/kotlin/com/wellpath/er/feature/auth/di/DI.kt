package com.wellpath.er.feature.auth.di

import com.wellpath.er.feature.auth.viewmodel.AuthViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun authFeatureModule() = module {
    factoryOf(::AuthViewModel)
}
