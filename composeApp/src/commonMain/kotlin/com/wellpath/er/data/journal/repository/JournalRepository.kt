package com.wellpath.er.data.journal.repository

import com.wellpath.er.data.assignments.model.Assignment
import com.wellpath.er.data.journal.model.JournalRecord
import kotlinx.coroutines.flow.Flow

interface JournalRepository {

    fun getJournalRecords(): Flow<List<JournalRecord>>

    fun getJournalRecord(journalRecordId: String): Flow<JournalRecord?>

    fun addAssignment(
        journalRecordId: String,
        assignment: Assignment
    )

    fun addJournalPageEntry(
        journalRecordId: String,
        moodScore: Float,
        comment: String,
    )
}