package com.wellpath.er.feature.exercises.breathing.viewmodel.model

import com.wellpath.er.ui.viewmodel.model.Event

data class BreathingUiState(
    val items: List<Any> = emptyList(),
    private val startingMillis: Long? = null,
    private val endingMillis: Long? = null,
) {
    val elapsedTime: String
        get() {
            if (startingMillis == null || endingMillis == null) return ""
            val elapsedMillis = endingMillis - startingMillis
            val totalSecond = elapsedMillis / MILLIS_DIVIDER
            val elapsedMinutes = totalSecond / SECONDS_DIVIDER
            val elapsedSeconds = totalSecond % SECONDS_DIVIDER

            return when {
                elapsedMinutes > 0 -> "${elapsedMinutes}m ${elapsedSeconds}s"
                else -> "${elapsedSeconds}s"
            }
        }

    enum class BreathingEvent : Event {
        SAVE_SUCCESSFUL
    }

    companion object {
        private const val MILLIS_DIVIDER = 1000
        private const val SECONDS_DIVIDER = 60
    }
}
