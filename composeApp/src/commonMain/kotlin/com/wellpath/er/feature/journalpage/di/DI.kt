package com.wellpath.er.feature.journalpage.di

import com.wellpath.er.feature.journalpage.viewmodel.JournalPageViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun journalPageFeatureModule() = module {
    viewModelOf(::JournalPageViewModel)
}