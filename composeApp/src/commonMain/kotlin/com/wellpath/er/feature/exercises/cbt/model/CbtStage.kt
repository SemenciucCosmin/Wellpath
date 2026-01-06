package com.wellpath.er.feature.exercises.cbt.model

import org.jetbrains.compose.resources.StringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_automatic_thought_clue
import wellpath.composeapp.generated.resources.lbl_automatic_thought_instruction
import wellpath.composeapp.generated.resources.lbl_automatic_thought_title
import wellpath.composeapp.generated.resources.lbl_balanced_thought_clue
import wellpath.composeapp.generated.resources.lbl_balanced_thought_instruction
import wellpath.composeapp.generated.resources.lbl_balanced_thought_title
import wellpath.composeapp.generated.resources.lbl_emotion_and_intensity_clue
import wellpath.composeapp.generated.resources.lbl_emotion_and_intensity_instruction
import wellpath.composeapp.generated.resources.lbl_emotion_and_intensity_title
import wellpath.composeapp.generated.resources.lbl_evidence_against_thought_clue
import wellpath.composeapp.generated.resources.lbl_evidence_against_thought_instruction
import wellpath.composeapp.generated.resources.lbl_evidence_against_thought_title
import wellpath.composeapp.generated.resources.lbl_evidence_for_thought_clue
import wellpath.composeapp.generated.resources.lbl_evidence_for_thought_instruction
import wellpath.composeapp.generated.resources.lbl_evidence_for_thought_title
import wellpath.composeapp.generated.resources.lbl_re_rate_emotion_clue
import wellpath.composeapp.generated.resources.lbl_re_rate_emotion_instruction
import wellpath.composeapp.generated.resources.lbl_re_rate_emotion_title
import wellpath.composeapp.generated.resources.lbl_situation_clue
import wellpath.composeapp.generated.resources.lbl_situation_instruction
import wellpath.composeapp.generated.resources.lbl_situation_title

enum class CbtStage(
    val id: Int,
    val titleRes: StringResource,
    val instructionRes: StringResource,
    val clueRes: StringResource
) {
    SITUATION(
        id = 0,
        titleRes = Res.string.lbl_situation_title,
        instructionRes = Res.string.lbl_situation_instruction,
        clueRes = Res.string.lbl_situation_clue
    ),
    AUTOMATIC_THOUGHT(
        id = 1,
        titleRes = Res.string.lbl_automatic_thought_title,
        instructionRes = Res.string.lbl_automatic_thought_instruction,
        clueRes = Res.string.lbl_automatic_thought_clue
    ),
    EMOTION_AND_INTENSITY(
        id = 2,
        titleRes = Res.string.lbl_emotion_and_intensity_title,
        instructionRes = Res.string.lbl_emotion_and_intensity_instruction,
        clueRes = Res.string.lbl_emotion_and_intensity_clue
    ),
    EVIDENCE_FOR_THOUGHT(
        id = 3,
        titleRes = Res.string.lbl_evidence_for_thought_title,
        instructionRes = Res.string.lbl_evidence_for_thought_instruction,
        clueRes = Res.string.lbl_evidence_for_thought_clue
    ),
    EVIDENCE_AGAINST_THOUGHT(
        id = 4,
        titleRes = Res.string.lbl_evidence_against_thought_title,
        instructionRes = Res.string.lbl_evidence_against_thought_instruction,
        clueRes = Res.string.lbl_evidence_against_thought_clue
    ),
    BALANCED_THOUGHT(
        id = 5,
        titleRes = Res.string.lbl_balanced_thought_title,
        instructionRes = Res.string.lbl_balanced_thought_instruction,
        clueRes = Res.string.lbl_balanced_thought_clue
    ),
    RE_RATE_EMOTION(
        id = 6,
        titleRes = Res.string.lbl_re_rate_emotion_title,
        instructionRes = Res.string.lbl_re_rate_emotion_instruction,
        clueRes = Res.string.lbl_re_rate_emotion_clue
    );

    companion object {
        fun getById(id: Int): CbtStage {
            return CbtStage.entries.firstOrNull { it.id == id } ?: SITUATION
        }
    }
}