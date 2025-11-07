package com.wellpath.er.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wellpath.er.ui.dimension.Spacing
import org.jetbrains.compose.resources.painterResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_heart
import wellpath.composeapp.generated.resources.ic_heart_outline

@Composable
fun FavouriteButton(
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface
        )
    ) {
        Image(
            modifier = Modifier.padding(Spacing.Small),
            contentDescription = null,
            painter = when {
                isSelected -> painterResource(Res.drawable.ic_heart)
                else -> painterResource(Res.drawable.ic_heart_outline)
            }
        )
    }
}
