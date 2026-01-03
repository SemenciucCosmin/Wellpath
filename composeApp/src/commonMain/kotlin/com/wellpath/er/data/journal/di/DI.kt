package com.wellpath.er.data.journal.di

import com.wellpath.er.data.journal.repository.JournalRepository
import com.wellpath.er.data.journal.repository.JournalRepositoryImpl
import org.koin.dsl.module

fun journalDataModule() = module {
    single<JournalRepository> { JournalRepositoryImpl() }
}