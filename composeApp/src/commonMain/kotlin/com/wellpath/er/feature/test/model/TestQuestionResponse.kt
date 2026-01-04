package com.wellpath.er.feature.test.model

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.StringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_agree
import wellpath.composeapp.generated.resources.lbl_disagree
import wellpath.composeapp.generated.resources.lbl_neutral
import wellpath.composeapp.generated.resources.lbl_strongly_agree
import wellpath.composeapp.generated.resources.lbl_strongly_disagree

/**
 * Enum class for all possible question responses
 * @param [score]: value scored for each response
 * @param [selectedColor]: color for selected state
 * @param [unselectedColor]: color for unselected state
 * @param [labelRes]: string resource as description for each response
 */
enum class TestQuestionResponse(
    val score: Int,
    val selectedColor: Color,
    val unselectedColor: Color,
    val labelRes: StringResource
) {
    STRONGLY_DISAGREE(
        score = 1,
        selectedColor = Color(0xFFE2978B),
        unselectedColor = Color(0xFFFCE9E6),
        labelRes = Res.string.lbl_strongly_disagree
    ),
    DISAGREE(
        score = 2,
        selectedColor = Color(0xFFD9AB85),
        unselectedColor = Color(0xFFFDF1E7),
        labelRes = Res.string.lbl_disagree
    ),
    NEUTRAL(
        score = 3,
        selectedColor = Color(0xFFC8C8C8),
        unselectedColor = Color(0xFFF9FAFA),
        labelRes = Res.string.lbl_neutral
    ),
    AGREE(
        score = 4,
        selectedColor = Color(0xFFB7C2B7),
        unselectedColor = Color(0xFFE7F7E7),
        labelRes = Res.string.lbl_agree
    ),
    STRONGLY_AGREE(
        score = 5,
        selectedColor = Color(0xFF86CFB1),
        unselectedColor = Color(0xFFDEF4EB),
        labelRes = Res.string.lbl_strongly_agree
    );

    companion object {
        fun getByScore(score: Int?): TestQuestionResponse? {
            return entries.firstOrNull { it.score == score }
        }
    }
}
