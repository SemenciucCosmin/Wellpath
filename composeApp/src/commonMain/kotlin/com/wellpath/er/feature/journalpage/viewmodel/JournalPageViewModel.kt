package com.wellpath.er.feature.journalpage.viewmodel

import androidx.lifecycle.ViewModel
import com.wellpath.er.feature.journalpage.viewmodel.model.JournalPageUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class JournalPageViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(JournalPageUiState())
    val uiState = _uiState.asStateFlow()

    fun changeMoodScore(value: Float) {
        _uiState.update {
            it.copy(moodScore = value)
        }
    }

    fun changeJournalEntry(value: String) {
        _uiState.update {
            it.copy(journalEntry = value)
        }
    }

    fun saveJournalPage() {
    }
}
