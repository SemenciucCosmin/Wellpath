package com.wellpath.er.feature.exercises.breathing.model

import org.jetbrains.compose.resources.StringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_empty
import wellpath.composeapp.generated.resources.lbl_exhale
import wellpath.composeapp.generated.resources.lbl_finished
import wellpath.composeapp.generated.resources.lbl_hold
import wellpath.composeapp.generated.resources.lbl_inhale
import wellpath.composeapp.generated.resources.lbl_start
import wellpath.composeapp.generated.resources.lbl_start_again
import wellpath.composeapp.generated.resources.lbl_stop

enum class BreathingStage(
    val buttonLabelRes: StringResource,
    val indicatorLabelRes: StringResource
) {
    READY(
        buttonLabelRes = Res.string.lbl_start,
        indicatorLabelRes = Res.string.lbl_empty
    ),
    INHALE(
        buttonLabelRes = Res.string.lbl_stop,
        indicatorLabelRes = Res.string.lbl_inhale
    ),
    INHALE_HOLD(
        buttonLabelRes = Res.string.lbl_stop,
        indicatorLabelRes = Res.string.lbl_hold
    ),
    EXHALE(
        buttonLabelRes = Res.string.lbl_stop,
        indicatorLabelRes = Res.string.lbl_exhale
    ),
    EXHALE_HOLD(
        buttonLabelRes = Res.string.lbl_stop,
        indicatorLabelRes = Res.string.lbl_hold
    ),
    FINISHED(
        buttonLabelRes = Res.string.lbl_start_again,
        indicatorLabelRes = Res.string.lbl_finished
    )
}