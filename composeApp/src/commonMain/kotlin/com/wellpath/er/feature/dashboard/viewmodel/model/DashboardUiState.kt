package com.wellpath.er.feature.dashboard.viewmodel.model

import com.wellpath.er.data.assignments.model.Assignment
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

data class DashboardUiState(
    val assignments: ImmutableList<Assignment> = persistentListOf()
) {
    @OptIn(ExperimentalTime::class)
    val currentJournalRecordId: String
        get() {
            val currentDate = Clock.System.now().toLocalDateTime(
                TimeZone.currentSystemDefault()
            )

            return "${currentDate.day}${currentDate.month}${currentDate.year}"
        }
}
