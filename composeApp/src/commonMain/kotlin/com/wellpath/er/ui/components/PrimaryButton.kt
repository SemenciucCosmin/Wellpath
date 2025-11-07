package com.wellpath.er.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.wellpath.er.ui.dimension.Radius
import com.wellpath.er.ui.dimension.Spacing
import org.jetbrains.compose.resources.painterResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_arrow_right_large

/**
 * Generic custom primary button
 */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(Radius.Large),
        enabled = enabled,
        contentPadding = PaddingValues(
            vertical = Spacing.Medium,
            horizontal = Spacing.XXLarge
        ),
        content = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(Spacing.Small),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyMedium,
                )

                Icon(
                    painter = painterResource(Res.drawable.ic_arrow_right_large),
                    contentDescription = null
                )
            }
        }
    )
}