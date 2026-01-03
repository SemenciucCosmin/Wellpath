package com.wellpath.er.data.journal.repository

import com.wellpath.er.data.assignments.model.Assignment
import com.wellpath.er.data.journal.model.JournalRecord
import com.wellpath.er.data.journal.model.Month
import com.wellpath.er.domain.extensions.BLANK
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.update
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.random.Random
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class JournalRepositoryImpl(
    private val coroutineScope: CoroutineScope,
) : JournalRepository {

    private val _journalRecords = MutableStateFlow(getMockJournalRecords())
    private val journalRecords = _journalRecords.stateIn(
        scope = coroutineScope,
        started = SharingStarted.Lazily,
        initialValue = getMockJournalRecords()
    )

    override fun getJournalRecords(): Flow<List<JournalRecord>> {
        return journalRecords.transform {
            emit(
                it.sortedWith(
                    compareBy<JournalRecord> { it.year }
                        .thenBy { it.month }
                        .thenBy { it.day }
                )
            )
        }
    }

    override fun getJournalRecord(journalRecordId: String): Flow<JournalRecord?> {
        return journalRecords.transform { records ->
            emit(records.firstOrNull { it.id == journalRecordId })
        }
    }

    @OptIn(ExperimentalTime::class)
    override fun addAssignment(
        journalRecordId: String,
        assignment: Assignment,
    ) {
        val currentJournalRecord = _journalRecords.value.firstOrNull { it.id == journalRecordId }
        val newAssignments = when {
            currentJournalRecord?.assignments?.map {
                it.type
            }?.contains(assignment.type) == true -> {
                currentJournalRecord.assignments.map {
                    when {
                        it.type == assignment.type -> it.copy(isCompleted = true)
                        else -> it
                    }
                }
            }

            else -> {
                currentJournalRecord?.assignments?.toMutableList()?.apply {
                    add(assignment)
                } ?: emptyList()
            }
        }

        val newJournalRecord = currentJournalRecord?.copy(
            assignments = newAssignments.toImmutableList()
        )

        newJournalRecord?.let {
            val newRecords = _journalRecords.value.map { journalRecord ->
                when {
                    journalRecord.id == newJournalRecord.id -> newJournalRecord
                    else -> journalRecord
                }
            }

            _journalRecords.update { newRecords }
        }
    }

    @OptIn(ExperimentalTime::class)
    override fun addJournalPageEntry(
        journalRecordId: String,
        moodScore: Float,
        comment: String,
    ) {
        val currentJournalRecord = _journalRecords.value.firstOrNull { it.id == journalRecordId }
        val assignments = currentJournalRecord?.assignments?.map {
            when (it.type) {
                Assignment.Type.JOURNAL_PAGE -> it.copy(isCompleted = true)
                else -> it
            }
        }?.toImmutableList() ?: persistentListOf()

        val newJournalRecord = currentJournalRecord?.copy(
            moodScore = moodScore,
            comment = comment,
            assignments = assignments
        )

        newJournalRecord?.let {
            val newRecords = _journalRecords.value.map { journalRecord ->
                when {
                    journalRecord.id == newJournalRecord.id -> newJournalRecord
                    else -> journalRecord
                }
            }

            _journalRecords.update { newRecords }
        }
    }

    @Suppress("CyclomaticComplexMethod")
    @OptIn(ExperimentalTime::class)
    private fun getMockJournalRecords(): List<JournalRecord> {
        val currentDate = Clock.System.now().toLocalDateTime(
            TimeZone.currentSystemDefault()
        )

        val mockRecords = (2025..2026).map { year ->
            Month.entries.map { month ->
                (1..month.days).map { day ->
                    val comment = getMockComments().random().takeIf {
                        Random.nextBoolean()
                    } ?: String.BLANK

                    JournalRecord(
                        id = "$day$month$year",
                        day = day,
                        month = month,
                        year = year,
                        moodScore = when {
                            comment.isNotEmpty() -> (0..10).random().toFloat()
                            else -> 5f
                        },
                        comment = comment,
                        assignments = Assignment.Type.entries.mapNotNull { type ->
                            Assignment(
                                type = type,
                                isCompleted = when (type) {
                                    Assignment.Type.JOURNAL_PAGE -> comment.isNotEmpty()
                                    else -> Random.nextBoolean()
                                },
                                day = day,
                                month = month,
                                year = year
                            ).takeIf {
                                when (it.type) {
                                    Assignment.Type.JOURNAL_PAGE -> true
                                    else -> Random.nextBoolean()
                                }
                            }
                        }.toImmutableList()
                    )
                }
            }.flatten()
        }.flatten().toImmutableList()

        val clearedMockRecords = mockRecords.map { record ->
            val hasHigherYear = record.year > currentDate.year
            val isSameYear = record.year == currentDate.year
            val hasHigherMonth = record.month.ordinal > currentDate.month.ordinal
            val isSameMonth = record.month.ordinal == currentDate.month.ordinal
            val hasHigherDay = record.day > currentDate.day

            val emptyRecord = record.copy(
                moodScore = 5f,
                comment = String.BLANK,
                assignments = persistentListOf()
            )

            when {
                hasHigherYear -> emptyRecord
                (hasHigherYear || isSameYear) && hasHigherMonth -> emptyRecord
                (hasHigherYear || isSameYear) && (hasHigherMonth || isSameMonth) && hasHigherDay -> {
                    emptyRecord
                }

                else -> record
            }
        }

        return clearedMockRecords
    }

    @Suppress("MaxLineLength")
    private fun getMockComments() = listOf(
        "Today moved at a slower pace, and although I didn’t accomplish everything I planned, I tried to stay present and accept the natural rhythm of the day without judging myself too harshly for what was left undone.",
        "There were several moments that felt challenging today, but I noticed myself pausing and taking a breath instead of reacting immediately, which helped me respond in a calmer and more thoughtful way.",
        "I felt quite tired for most of the day and became more aware of how much my body was asking for rest, reminding me that slowing down is sometimes more important than pushing through.",
        "Some emotions stayed with me longer than I would have liked today, and instead of fighting them, I tried to acknowledge their presence and allow them to exist without needing to fix them right away.",
        "Even though the day was busy, I found a few small and quiet moments that helped me feel grounded and more connected to myself.",
        "I noticed that my focus was better than usual today, and it felt reassuring to stay engaged with what I was doing rather than feeling constantly pulled in different directions.",
        "The overall tone of the day felt stressful, but despite that, I managed to handle what needed to be done and reminded myself that effort still counts, even when things feel heavy.",
        "I made a conscious effort to slow down and approach the day one step at a time, which helped reduce some of the pressure I usually place on myself.",
        "At times I felt disconnected from others and from my surroundings, but I reminded myself that this feeling is temporary and doesn’t define my relationships or my worth.",
        "Today I became more aware of my thoughts and noticed patterns in the way I speak to myself, which gave me something to reflect on rather than something to criticize.",
        "I needed extra patience today, especially with myself, and I tried to respond to mistakes and frustrations with a little more understanding than usual.",
        "The day included both difficult and positive moments, and I noticed that neither one fully captured how the day truly felt when I looked at it as a whole.",
        "Feeling supported today, even in small ways, made a noticeable difference in how manageable the day felt emotionally.",
        "Even when things felt hard or uncomfortable, I showed up and did the best I could with the energy and resources I had available.",
        "I made a deliberate effort to treat myself with kindness today, especially during moments when my inner critic was louder than usual.",
        "There were moments when I felt overwhelmed, and stepping away for short breaks helped me regain a sense of balance and clarity.",
        "The quieter moments of the day gave me space to reflect and check in with how I was truly feeling beneath the surface.",
        "I allowed myself to rest more than I usually do, and it felt like a necessary and supportive choice rather than something to feel guilty about.",
        "By the end of the day, I noticed a subtle shift toward feeling lighter and more settled emotionally, even if everything wasn’t resolved.",
        "Today offered a few meaningful insights about myself that I want to carry forward and keep in mind as I move into the next days."
    )
}