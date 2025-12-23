package com.wellpath.er.feature.startup.viewmodel

import androidx.lifecycle.viewModelScope
import com.wellpath.er.data.auth.repository.AuthRepository
import com.wellpath.er.feature.startup.viewmodel.model.StartupEvent
import com.wellpath.er.ui.viewmodel.EventViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class StartupViewModel(
    private val authRepository: AuthRepository,
) : EventViewModel<StartupEvent>() {

    init {
        checkAuth()
    }

    private fun checkAuth() {
        viewModelScope.launch {
            authRepository.getCurrentUserFlow().collectLatest { user ->
                when (user) {
                    null -> registerEvent(StartupEvent.NOT_SIGNED_IN)
                    else -> registerEvent(StartupEvent.SIGNED_IN)
                }
            }
        }
    }
}