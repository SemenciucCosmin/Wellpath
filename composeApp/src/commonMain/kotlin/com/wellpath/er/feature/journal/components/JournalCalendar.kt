package com.wellpath.er.feature.journal.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wellpath.er.data.journal.model.JournalRecord
import com.wellpath.er.ui.theme.Pds
import kotlinx.collections.immutable.ImmutableList

private const val COLUMNS_COUNT = 7

@Composable
fun JournalCalendar(
    currentJournalRecordId: String,
    journalRecords: ImmutableList<JournalRecord>,
    onJournalRecordClick: (JournalRecord) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(COLUMNS_COUNT),
        verticalArrangement = Arrangement.spacedBy(Pds.spacing.SMedium),
        horizontalArrangement = Arrangement.spacedBy(Pds.spacing.SMedium),
    ) {
        items(journalRecords) { record ->
            Card(
                modifier = Modifier.height(100.dp),
                shape = MaterialTheme.shapes.small,
                onClick = { onJournalRecordClick(record) },
                border = when {
                    currentJournalRecordId != record.id -> null
                    else -> BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
                }
            ) {
                Column(
                    modifier = Modifier.padding(Pds.spacing.XSmall),
                    verticalArrangement = Arrangement.spacedBy(Pds.spacing.XSmall)
                ) {
                    Text(
                        text = record.day.toString(),
                        style = MaterialTheme.typography.labelMedium,
                    )

                    record.assignments.forEach { assignment ->
                        Box(
                            modifier = Modifier
                                .background(assignment.type.color)
                                .height(Pds.spacing.Small)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}