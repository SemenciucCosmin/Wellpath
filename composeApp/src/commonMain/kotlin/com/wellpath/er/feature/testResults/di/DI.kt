package com.wellpath.er.feature.testResults.di

import com.wellpath.er.feature.testResults.viewmodel.TestResultsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun testResultsFeatureModule() = module {
    viewModelOf(::TestResultsViewModel)
}