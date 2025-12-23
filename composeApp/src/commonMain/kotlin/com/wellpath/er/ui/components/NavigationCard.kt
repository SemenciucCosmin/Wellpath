package com.wellpath.er.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.wellpath.er.ui.theme.Pds

@Composable
fun NavigationCard(
    title: String,
    text: String,
    painter: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        onClick = onClick,
        color = MaterialTheme.colorScheme.tertiaryContainer,
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Pds.spacing.Small),
            modifier = Modifier.padding(Pds.spacing.SMedium)
                .fillMaxWidth()
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(Pds.spacing.Small)) {
                Icon(
                    modifier = Modifier.size(Pds.icon.Small),
                    painter = painter,
                    contentDescription = null,
                )

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                )
            }

            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
