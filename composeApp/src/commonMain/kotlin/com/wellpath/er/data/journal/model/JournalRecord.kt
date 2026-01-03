package com.wellpath.er.data.journal.model

import com.wellpath.er.data.assignments.model.Assignment
import kotlinx.collections.immutable.ImmutableList
import kotlinx.datetime.Month

data class JournalRecord(
    val id: String,
    val day: Int,
    val month: Month,
    val year: Int,
    val moodScore: Float,
    val comment: String,
    val assignments: ImmutableList<Assignment>
)