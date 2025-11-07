package com.wellpath.er.feature.auth.viewmodel.model

import com.wellpath.er.feature.auth.model.AuthScreenType
import com.wellpath.er.feature.auth.model.PasswordError
import com.wellpath.er.domain.extensions.BLANK
import com.wellpath.er.feature.auth.model.EmailError
import com.wellpath.er.ui.viewmodel.model.Event

/**
 * Data class for auth flow state
 */
data class AuthUiState(
    val authScreenType: AuthScreenType = AuthScreenType.SIGN_UP,
    val email: String = String.BLANK,
    val password: String = String.BLANK,
    val secondaryPassword: String = String.BLANK,
    val emailError: EmailError = EmailError.NONE,
    val passwordError: PasswordError = PasswordError.NONE,
    val secondaryPasswordError: PasswordError = PasswordError.NONE,
    val isLoading: Boolean = false
) {
    enum class AuthEvent : Event {
        SIGNED
    }
}
