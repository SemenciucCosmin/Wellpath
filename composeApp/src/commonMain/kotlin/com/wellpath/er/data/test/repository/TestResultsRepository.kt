package com.wellpath.er.data.test.repository

import com.wellpath.er.data.test.model.BFIDimension
import kotlinx.coroutines.flow.Flow

interface TestResultsRepository {

    fun getTestResults(): Flow<Map<BFIDimension, Int>>

    fun setTestResults(results: Map<BFIDimension, Int>)
}