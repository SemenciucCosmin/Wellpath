package com.wellpath.er.feature.exercises.breathing.route

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.wellpath.er.feature.exercises.breathing.model.BreathingStage
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.stringResource

private const val STAGE_DURATION = 3000
private const val BUBBLE_START_SIZE = 120f
private const val BUBBLE_TARGET_SIZE = 300f

@Composable
fun BreathingBubbleButton(
    currentStage: BreathingStage,
    onStageChange: (BreathingStage) -> Unit,
) {
    val bubbleSize = remember { Animatable(BUBBLE_START_SIZE) }

    LaunchedEffect(currentStage) {
        when (currentStage) {
            BreathingStage.READY -> Unit
            BreathingStage.INHALE -> {
                bubbleSize.animateTo(
                    animationSpec = tween(durationMillis = STAGE_DURATION, easing = LinearEasing),
                    targetValue = BUBBLE_TARGET_SIZE,
                    block = {
                        if (value == BUBBLE_TARGET_SIZE) {
                            onStageChange(BreathingStage.INHALE_HOLD)
                        }
                    }
                )
            }

            BreathingStage.INHALE_HOLD -> {
                delay(STAGE_DURATION.toLong())
                onStageChange(BreathingStage.EXHALE)
            }

            BreathingStage.EXHALE -> {
                bubbleSize.animateTo(
                    animationSpec = tween(durationMillis = STAGE_DURATION, easing = LinearEasing),
                    targetValue = BUBBLE_START_SIZE,
                    block = {
                        if (value == BUBBLE_START_SIZE) {
                            onStageChange(BreathingStage.EXHALE_HOLD)
                        }
                    }
                )
            }

            BreathingStage.EXHALE_HOLD -> {
                delay(STAGE_DURATION.toLong())
                onStageChange(BreathingStage.INHALE)
            }

            BreathingStage.FINISHED -> {
                bubbleSize.snapTo(BUBBLE_START_SIZE)
                bubbleSize.stop()
            }
        }
    }

    Box {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(bubbleSize.value.dp)
                .align(Alignment.Center)
        )

        Button(
            shape = CircleShape,
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.Center),
            onClick = {
                onStageChange(
                    when (currentStage) {
                        BreathingStage.READY,
                        BreathingStage.FINISHED -> BreathingStage.INHALE

                        BreathingStage.INHALE,
                        BreathingStage.INHALE_HOLD,
                        BreathingStage.EXHALE,
                        BreathingStage.EXHALE_HOLD -> BreathingStage.FINISHED
                    }
                )
            },
        ) {
            Text(
                text = stringResource(currentStage.buttonLabelRes),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
            )
        }
    }
}