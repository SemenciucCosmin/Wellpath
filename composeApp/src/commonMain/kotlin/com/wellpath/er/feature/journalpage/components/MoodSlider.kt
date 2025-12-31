package com.wellpath.er.feature.journalpage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.stringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_mood_slider_description
import wellpath.composeapp.generated.resources.lbl_mood_slider_max
import wellpath.composeapp.generated.resources.lbl_mood_slider_medium
import wellpath.composeapp.generated.resources.lbl_mood_slider_min

private const val MIN_MOOD_SCORE = 0f
private const val MAX_MOOD_SCORE = 10f

@Suppress("MagicNumber")
@Composable
fun MoodSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
) {
    val sliderGradient = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFF44336),
            Color(0xFFFFC107),
            Color(0xFF4CAF50),
        )
    )

    Column(verticalArrangement = Arrangement.spacedBy(Pds.spacing.SMedium)) {
        Text(
            text = stringResource(Res.string.lbl_mood_slider_description),
            style = MaterialTheme.typography.labelLarge
        )

        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = MIN_MOOD_SCORE..MAX_MOOD_SCORE,
            colors = SliderDefaults.colors(
                activeTrackColor = Color.Transparent,
                inactiveTrackColor = Color.Transparent,
                thumbColor = Color.White
            ),
            modifier = modifier.background(sliderGradient, MaterialTheme.shapes.extraLarge)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(Res.string.lbl_mood_slider_min),
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                text = stringResource(Res.string.lbl_mood_slider_medium),
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                text = stringResource(Res.string.lbl_mood_slider_max),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}
