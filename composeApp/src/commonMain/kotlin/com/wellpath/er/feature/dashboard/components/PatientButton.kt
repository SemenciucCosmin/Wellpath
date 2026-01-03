package com.wellpath.er.feature.dashboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.painterResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_switch

@Composable
fun PatientButton(
    patientName: String,
    onClick: () -> Unit,
) {
    FilledTonalButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Pds.spacing.Small),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_switch),
                contentDescription = null
            )

            Text(
                text = patientName,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}