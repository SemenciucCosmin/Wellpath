package com.wellpath.er.data.test.repository

import com.wellpath.er.data.test.model.BFIDimension
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class TestResultsRepositoryImpl : TestResultsRepository {

    private val testResults = MutableStateFlow(getMockedTestResults())

    override fun getTestResults(): Flow<Map<BFIDimension, Int>> {
        return testResults
    }

    override fun setTestResults(results: Map<BFIDimension, Int>) {
        testResults.update { results }
    }

    private fun getMockedTestResults() = BFIDimension.entries.associateWith {
        (12..87).random()
    }
}