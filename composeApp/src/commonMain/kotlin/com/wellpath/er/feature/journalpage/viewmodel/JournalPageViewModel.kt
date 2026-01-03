package com.wellpath.er.feature.journalpage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wellpath.er.data.journal.repository.JournalRepository
import com.wellpath.er.feature.journalpage.viewmodel.model.JournalPageUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class JournalPageViewModel(
    private val journalRecordId: String,
    private val journalRepository: JournalRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(JournalPageUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getJournalRecord()
    }

    private fun getJournalRecord() {
        viewModelScope.launch {
            journalRepository.getJournalRecord(journalRecordId).filterNotNull().collectLatest {
                _uiState.update { state ->
                    state.copy(
                        moodScore = it.moodScore,
                        comment = it.comment,
                        assignments = it.assignments
                    )
                }
            }
        }
    }

    fun changeMoodScore(value: Float) {
        _uiState.update {
            it.copy(moodScore = value)
        }
    }

    fun changeComment(value: String) {
        _uiState.update {
            it.copy(comment = value)
        }
    }

    fun saveJournalPage() {
        journalRepository.addJournalPageEntry(
            journalRecordId = journalRecordId,
            moodScore = _uiState.value.moodScore,
            comment = _uiState.value.comment
        )
    }
}
