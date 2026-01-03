package com.wellpath.er.feature.journal.viewmodel.model

import com.wellpath.er.data.journal.model.JournalRecord
import com.wellpath.er.data.journal.model.Month
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

data class JournalUiState
@OptIn(ExperimentalTime::class)
constructor(
    private val records: ImmutableList<JournalRecord> = persistentListOf(),
    val selectedYear: Int = Clock.System.now().toLocalDateTime(
        TimeZone.currentSystemDefault()
    ).year,
    val selectedMonth: Month = Month.getById(
        Clock.System.now().toLocalDateTime(
            TimeZone.currentSystemDefault()
        ).month.ordinal
    ),
) {
    val filteredRecords: ImmutableList<JournalRecord>
        get() = records.filter { record ->
            record.month == selectedMonth && record.year == selectedYear
        }.sortedBy { it.day }.toImmutableList()

    val selectedDate: String
        get() {
            val month = selectedMonth.name.lowercase().capitalize()
            return "$month $selectedYear"
        }

    @OptIn(ExperimentalTime::class)
    val currentJournalRecordId: String
        get() {
            val currentDate = Clock.System.now().toLocalDateTime(
                TimeZone.currentSystemDefault()
            )

            return "${currentDate.day}${currentDate.month}${currentDate.year}"
        }

    enum class PagingDirection {
        LEFT,
        RIGHT
    }
}
