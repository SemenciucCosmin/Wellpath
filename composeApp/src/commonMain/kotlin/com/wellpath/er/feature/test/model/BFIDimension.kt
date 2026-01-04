package com.wellpath.er.feature.test.model

import com.wellpath.er.data.test.model.BFIDimension
import org.jetbrains.compose.resources.StringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_agreeableness
import wellpath.composeapp.generated.resources.lbl_conscientiousness
import wellpath.composeapp.generated.resources.lbl_extraversion
import wellpath.composeapp.generated.resources.lbl_neuroticism
import wellpath.composeapp.generated.resources.lbl_openness

val BFIDimension.labelRes: StringResource
    get() = when (this) {
        BFIDimension.OPENNESS -> Res.string.lbl_openness
        BFIDimension.CONSCIENTIOUSNESS -> Res.string.lbl_conscientiousness
        BFIDimension.EXTRAVERSION -> Res.string.lbl_extraversion
        BFIDimension.AGREEABLENESS -> Res.string.lbl_agreeableness
        BFIDimension.NEUROTICISM -> Res.string.lbl_neuroticism
    }
