package com.wellpath.er.feature.journalpage.viewmodel.model

import com.wellpath.er.domain.extensions.BLANK
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

data class JournalPageUiState(
    val moodScore: Float = DEFAULT_MOOD_SCORE,
    val journalEntry: String = String.BLANK,
) {
    @OptIn(ExperimentalTime::class)
    val date: String
        get() {
            val currentInstant = Clock.System.now()
            val currentDate = currentInstant.toLocalDateTime(TimeZone.currentSystemDefault())
            val month = currentDate.month.name.lowercase().capitalize()
            return "${currentDate.day} $month ${currentDate.year}"
        }

    companion object {
        private const val DEFAULT_MOOD_SCORE = 5f
    }
}
