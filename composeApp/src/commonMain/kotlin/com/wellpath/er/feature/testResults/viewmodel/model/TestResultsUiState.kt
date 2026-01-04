package com.wellpath.er.feature.testResults.viewmodel.model

import com.wellpath.er.data.test.model.BFIDimension

data class TestResultsUiState(
    val results: Map<BFIDimension, Int> = emptyMap()
)
