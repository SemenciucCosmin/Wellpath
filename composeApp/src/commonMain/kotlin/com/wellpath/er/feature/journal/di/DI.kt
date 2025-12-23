package com.wellpath.er.feature.journal.di

import com.wellpath.er.feature.journal.viewmodel.JournalViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun journalFeatureModule() = module {
    viewModelOf(::JournalViewModel)
}