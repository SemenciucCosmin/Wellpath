package com.wellpath.er.data.journal.repository

import com.wellpath.er.data.assignments.model.Assignment
import com.wellpath.er.data.journal.model.JournalRecord

interface JournalRepository {

    fun getJournalRecords(): List<JournalRecord>

    fun getJournalRecord(journalRecordId: String): JournalRecord?

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