package com.wellpath.er.feature.auth.model

import org.jetbrains.compose.resources.StringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_sign_in
import wellpath.composeapp.generated.resources.lbl_sign_in_message
import wellpath.composeapp.generated.resources.lbl_sign_in_redirect_message
import wellpath.composeapp.generated.resources.lbl_sign_up
import wellpath.composeapp.generated.resources.lbl_sign_up_message
import wellpath.composeapp.generated.resources.lbl_sign_up_redirect_message

/**
 * Enum class for sign in and sign up authentication flow types.
 */
enum class AuthScreenType(
    val signLabelRes: StringResource,
    val messageLabelRes: StringResource,
    val redirectLabelRes: StringResource,
    val redirectSignLabelRes: StringResource,
) {
    SIGN_IN(
        signLabelRes = Res.string.lbl_sign_in,
        messageLabelRes = Res.string.lbl_sign_in_message,
        redirectLabelRes = Res.string.lbl_sign_up_redirect_message,
        redirectSignLabelRes = Res.string.lbl_sign_up,
    ),

    SIGN_UP(
        signLabelRes = Res.string.lbl_sign_up,
        messageLabelRes = Res.string.lbl_sign_up_message,
        redirectLabelRes = Res.string.lbl_sign_in_redirect_message,
        redirectSignLabelRes = Res.string.lbl_sign_in,
    )
}
