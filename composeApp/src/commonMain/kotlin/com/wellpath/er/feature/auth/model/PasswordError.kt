package com.wellpath.er.feature.auth.model

import org.jetbrains.compose.resources.StringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_empty
import wellpath.composeapp.generated.resources.lbl_empty_password
import wellpath.composeapp.generated.resources.lbl_invalid_password
import wellpath.composeapp.generated.resources.lbl_passwords_not_matching
import wellpath.composeapp.generated.resources.lbl_weak_password

/**
 * Enum class for all possible states of the password text field.
 */
enum class PasswordError(val label: StringResource) {
    EMPTY(Res.string.lbl_empty_password),
    INVALID(Res.string.lbl_invalid_password),
    NOT_MATCHING(Res.string.lbl_passwords_not_matching),
    WEAK(Res.string.lbl_weak_password),
    NONE(Res.string.lbl_empty)
}
