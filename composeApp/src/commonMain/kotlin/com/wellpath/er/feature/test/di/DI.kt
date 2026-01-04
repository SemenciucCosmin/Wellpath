package com.wellpath.er.feature.test.di

import com.wellpath.er.feature.test.viewmodel.TestViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun testFeatureModule() = module {
    scope(named(TestScope.ID)) {
        scoped { TestViewModel(get(), get()) }
    }
}
