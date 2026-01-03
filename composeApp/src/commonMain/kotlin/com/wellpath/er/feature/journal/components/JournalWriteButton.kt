package com.wellpath.er.feature.journal.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_edit
import wellpath.composeapp.generated.resources.lbl_write_in_journal

@Composable
fun JournalWriteButton(
    onClick: () -> Unit,
) {
    FloatingActionButton(onClick = onClick) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Pds.spacing.XSmall),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(Pds.spacing.Small)
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_edit),
                contentDescription = null,
                modifier = Modifier.size(Pds.icon.SMedium)
            )

            Text(
                text = stringResource(Res.string.lbl_write_in_journal),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}