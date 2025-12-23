package com.wellpath.er.feature.dashboard.di

import com.wellpath.er.feature.dashboard.viewmodel.DashboardViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun dashboardFeatureModule() = module {
    viewModelOf(::DashboardViewModel)
}