package com.wellpath.er.feature.journalpage.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.stringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_journal_entry_description

@Composable
fun JournalPageForm(
    moodScore: Float,
    journalEntry: String,
    isReadOnly: Boolean,
    onChangeMoodScore: (Float) -> Unit,
    onChangeJournalEntry: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        MoodSlider(
            value = moodScore,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { if (!isReadOnly) onChangeMoodScore(it) },
        )

        Spacer(modifier = Modifier.size(Pds.spacing.Large))

        HorizontalDivider()

        Spacer(modifier = Modifier.size(Pds.spacing.Large))

        Text(
            text = stringResource(Res.string.lbl_journal_entry_description),
            style = MaterialTheme.typography.labelLarge
        )

        Spacer(modifier = Modifier.size(Pds.spacing.XSmall))

        OutlinedTextField(
            readOnly = isReadOnly,
            value = journalEntry,
            onValueChange = { if (!isReadOnly) onChangeJournalEntry(it) },
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 400.dp)
        )
    }
}