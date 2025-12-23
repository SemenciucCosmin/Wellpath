package com.wellpath.er.feature.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import com.wellpath.er.feature.dashboard.viewmodel.model.DashboardUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState = _uiState.asStateFlow()
}
