package com.wellpath.er.feature.journalpage.viewmodel

import androidx.lifecycle.ViewModel
import com.wellpath.er.data.journal.repository.JournalRepository
import com.wellpath.er.feature.journalpage.viewmodel.model.JournalPageUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

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
        val journalRecord = journalRepository.getJournalRecord(journalRecordId) ?: return
        _uiState.update { state ->
            state.copy(
                moodScore = journalRecord.moodScore,
                comment = journalRecord.comment,
                assignments = journalRecord.assignments
            )
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
