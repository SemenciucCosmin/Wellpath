package com.wellpath.er.feature.test.viewmodel

import androidx.lifecycle.viewModelScope
import com.wellpath.er.data.test.datasource.BFIQuestionsDataSource
import com.wellpath.er.data.test.repository.TestResultsRepository
import com.wellpath.er.feature.test.viewmodel.model.TestUiState
import com.wellpath.er.ui.viewmodel.EventViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for form flow
 */
class TestViewModel(
    private val bfiQuestionsDataSource: BFIQuestionsDataSource,
    private val testResultsRepository: TestResultsRepository,
) : EventViewModel<TestUiState.TestEvent>() {

    private val _uiState = MutableStateFlow(TestUiState())
    val uiState: StateFlow<TestUiState> = _uiState.asStateFlow()
        .onStart { loadQuestions() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = _uiState.value
        )

    /**
     * Retrieves the BFI questions and prepares them for display
     */
    private fun loadQuestions() {
        _uiState.update {
            val bfiQuestions = bfiQuestionsDataSource.getBfiQuestions()
            it.copy(bfiPages = bfiQuestions.chunked(QUESTIONS_PER_PAGE))
        }
    }

    /**
     * Registers or changes a response for a certain question
     */
    fun registerResponse(questionId: Int, responseScore: Int) {
        _uiState.update {
            val newResponses = it.responses.toMutableMap().apply {
                this[questionId] = responseScore
            }

            it.copy(responses = newResponses)
        }
    }

    /**
     * Computes the overall score for each BFI Dimension, save then into Firestore and ends
     * the onboarding flow
     */
    fun finishForm() = viewModelScope.launch {
        val questionsCount = _uiState.value.bfiPages.flatten().size
        val responsesCount = _uiState.value.responses.size

        when {
            questionsCount != responsesCount -> registerEvent(TestUiState.TestEvent.NEXT_PAGE)

            else -> {
                val questions = _uiState.value.bfiPages.flatten()
                val groupedResponses = questions.mapNotNull { question ->
                    _uiState.value.responses[question.id]?.let { score ->
                        val signedScore = when {
                            question.reverseScore -> -score
                            else -> score
                        }

                        question.bfiDimension to signedScore
                    }
                }.groupBy({ it.first }, { it.second }).mapValues { (_, scores) -> scores.sum() }
                testResultsRepository.setTestResults(groupedResponses)
                registerEvent(TestUiState.TestEvent.FINISH_FORM)
            }
        }
    }

    companion object {
        private const val QUESTIONS_PER_PAGE = 3
    }
}
