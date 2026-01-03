package com.wellpath.er.data.assignments.model

import androidx.compose.ui.graphics.Color
import com.wellpath.er.data.journal.model.Month
import org.jetbrains.compose.resources.StringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_assignment_exercise_breathing
import wellpath.composeapp.generated.resources.lbl_assignment_exercise_breathing_message
import wellpath.composeapp.generated.resources.lbl_assignment_exercise_cbt
import wellpath.composeapp.generated.resources.lbl_assignment_exercise_cbt_message
import wellpath.composeapp.generated.resources.lbl_assignment_exercise_mindfulness
import wellpath.composeapp.generated.resources.lbl_assignment_exercise_mindfulness_message
import wellpath.composeapp.generated.resources.lbl_assignment_journal
import wellpath.composeapp.generated.resources.lbl_assignment_journal_message

data class Assignment(
    val type: Type,
    val isCompleted: Boolean,
    val day: Int,
    val month: Month,
    val year: Int,
) {
    enum class Type(
        val id: String,
        val labelRes: StringResource,
        val messageRes: StringResource,
        val color: Color,
    ) {
        JOURNAL_PAGE(
            id = "journal_page",
            labelRes = Res.string.lbl_assignment_journal,
            messageRes = Res.string.lbl_assignment_journal_message,
            color = Color(0xFFFF5F1F)
        ),
        EXERCISE_BREATHING(
            id = "exercise_breathing",
            labelRes = Res.string.lbl_assignment_exercise_breathing,
            messageRes = Res.string.lbl_assignment_exercise_breathing_message,
            color = Color(0xFF89CFF0)
        ),
        EXERCISE_CBT(
            id = "exercise_cbt",
            labelRes = Res.string.lbl_assignment_exercise_cbt,
            messageRes = Res.string.lbl_assignment_exercise_cbt_message,
            color = Color(0xFFFFDB58)
        ),
        EXERCISE_MINDFULNESS(
            id = "exercise_mindfulness",
            labelRes = Res.string.lbl_assignment_exercise_mindfulness,
            messageRes = Res.string.lbl_assignment_exercise_mindfulness_message,
            color = Color(0xFF32CD32)
        )
    }
}
