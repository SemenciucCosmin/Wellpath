package com.wellpath.er.feature.assignment.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.wellpath.er.data.assignments.model.Assignment
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_check
import wellpath.composeapp.generated.resources.lbl_completed

@Composable
fun AssignmentItem(
    assignment: Assignment,
    onClick: () -> Unit = {}
) {
    Card(onClick = onClick) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Pds.spacing.Medium),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(Pds.spacing.SMedium)
                .height(IntrinsicSize.Min)
        ) {
            Box(
                modifier = Modifier
                    .background(assignment.type.color)
                    .width(Pds.spacing.Small)
                    .fillMaxHeight()
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(Pds.spacing.XSmall),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(assignment.type.labelRes),
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = stringResource(assignment.type.messageRes),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            if (assignment.isCompleted) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(Pds.spacing.XSmall),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_check),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(Pds.icon.Medium)
                    )

                    Text(
                        text = stringResource(Res.string.lbl_completed),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
            }
        }
    }
}