package com.wellpath.er.feature.test.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_check

/**
 * Circle button for form question row
 */
@Composable
fun TestQuestionResponseButton(
    isSelected: Boolean,
    selectedColor: Color,
    unselectedColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(selectedColor)
            .size(40.dp)
            .clickable { onClick() }
    ) {
        Box(
            modifier = modifier
                .clip(CircleShape)
                .background(
                    when {
                        isSelected -> selectedColor
                        else -> unselectedColor
                    }
                )
                .size(38.dp)
                .align(Alignment.Center)
        ) {
            if (isSelected) {
                Icon(
                    painter = painterResource(Res.drawable.ic_check),
                    tint = Color.Black,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(30.dp)
                )
            }
        }
    }
}
