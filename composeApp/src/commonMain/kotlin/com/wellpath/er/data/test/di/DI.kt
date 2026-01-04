package com.wellpath.er.data.test.di

import com.wellpath.er.data.test.datasource.BFIQuestionsDataSource
import com.wellpath.er.data.test.datasource.BFIQuestionsDataSourceImpl
import com.wellpath.er.data.test.repository.TestResultsRepository
import com.wellpath.er.data.test.repository.TestResultsRepositoryImpl
import org.koin.dsl.module

fun testDataModule() = module {
    single<BFIQuestionsDataSource> { BFIQuestionsDataSourceImpl() }
    single<TestResultsRepository> { TestResultsRepositoryImpl() }
}
