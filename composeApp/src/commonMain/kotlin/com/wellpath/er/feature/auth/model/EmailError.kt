package com.wellpath.er.feature.auth.model

import org.jetbrains.compose.resources.StringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_email_collision
import wellpath.composeapp.generated.resources.lbl_empty
import wellpath.composeapp.generated.resources.lbl_empty_email
import wellpath.composeapp.generated.resources.lbl_invalid_email

/**
 * Enum class for all possible states of the email text field.
 */
enum class EmailError(val label: StringResource) {
    EMPTY(Res.string.lbl_empty_email),
    INVALID(Res.string.lbl_invalid_email),
    COLLISION(Res.string.lbl_email_collision),
    NONE(Res.string.lbl_empty)
}
