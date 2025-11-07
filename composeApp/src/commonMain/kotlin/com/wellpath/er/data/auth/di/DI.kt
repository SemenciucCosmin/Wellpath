package com.wellpath.er.data.auth.di

import com.wellpath.er.data.auth.repository.AuthRepository
import com.wellpath.er.data.auth.repository.AuthRepositoryImpl
import org.koin.dsl.module

fun authDataModule() = module {
    single<AuthRepository> { AuthRepositoryImpl() }
}
