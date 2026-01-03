package com.wellpath.er.feature.journal.viewmodel

import androidx.lifecycle.ViewModel
import com.wellpath.er.data.journal.model.Month
import com.wellpath.er.data.journal.repository.JournalRepository
import com.wellpath.er.feature.journal.viewmodel.model.JournalUiState
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class JournalViewModel(
    private val journalRepository: JournalRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(JournalUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadRecords()
    }

    private fun loadRecords() {
        _uiState.update {
            it.copy(records = journalRepository.getJournalRecords().toImmutableList())
        }
    }

    fun movePage(direction: JournalUiState.PagingDirection) {
        _uiState.update { state ->
            when (direction) {
                JournalUiState.PagingDirection.LEFT -> when (state.selectedMonth) {
                    Month.JANUARY -> state.copy(
                        selectedMonth = Month.DECEMBER,
                        selectedYear = state.selectedYear.dec()
                    )

                    else -> state.copy(
                        selectedMonth = Month.entries.first {
                            it.ordinal == state.selectedMonth.ordinal.dec()
                        }
                    )
                }

                JournalUiState.PagingDirection.RIGHT -> when (state.selectedMonth) {
                    Month.DECEMBER -> state.copy(
                        selectedMonth = Month.JANUARY,
                        selectedYear = state.selectedYear.inc()
                    )

                    else -> state.copy(
                        selectedMonth = Month.entries.first {
                            it.ordinal == state.selectedMonth.ordinal.inc()
                        }
                    )
                }
            }
        }
    }
}
