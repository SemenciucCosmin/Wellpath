package com.wellpath.er.feature.testResults.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wellpath.er.data.test.repository.TestResultsRepository
import com.wellpath.er.feature.testResults.viewmodel.model.TestResultsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TestResultsViewModel(
    private val testResultsRepository: TestResultsRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(TestResultsUiState())
    val uiState: StateFlow<TestResultsUiState> = _uiState.asStateFlow()

    init {
        loadResults()
    }

    private fun loadResults() {
        viewModelScope.launch {
            testResultsRepository.getTestResults().collectLatest {
                _uiState.update { state ->
                    state.copy(results = it)
                }
            }
        }
    }
}