package com.wellpath.er.feature.journal.viewmodel

import androidx.lifecycle.ViewModel
import com.wellpath.er.feature.dashboard.viewmodel.model.DashboardUiState
import com.wellpath.er.feature.journal.viewmodel.model.JournalUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class JournalViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(JournalUiState())
    val uiState = _uiState.asStateFlow()
}
