package com.wellpath.er.feature.journal.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.painterResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.circle_arrow_left
import wellpath.composeapp.generated.resources.circle_arrow_right

@Composable
fun JournalPagingControl(
    label: String,
    onLeftControlClick: () -> Unit,
    onRightControlClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Pds.spacing.Medium),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = onLeftControlClick) {
            Icon(
                painter = painterResource(Res.drawable.circle_arrow_left),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(Pds.icon.Small)
            )
        }

        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )

        IconButton(onClick = onRightControlClick) {
            Icon(
                painter = painterResource(Res.drawable.circle_arrow_right),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(Pds.icon.Small)
            )
        }
    }
}