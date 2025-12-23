package com.wellpath.er.feature.auth.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.wellpath.er.feature.auth.model.AuthScreenType
import com.wellpath.er.feature.auth.model.EmailError
import com.wellpath.er.feature.auth.model.PasswordError
import com.wellpath.er.ui.components.ProgressOverlay
import com.wellpath.er.ui.dimension.Spacing
import org.jetbrains.compose.resources.stringResource

/**
 * Screen for sign in and sign up flows
 */
@Suppress("MagicNumber")
@Composable
fun AuthScreen(
    authScreenType: AuthScreenType,
    isLoading: Boolean,
    email: String,
    password: String,
    secondaryPassword: String,
    emailError: EmailError,
    passwordError: PasswordError,
    secondaryPasswordError: PasswordError,
    snackbarHostState: SnackbarHostState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSecondaryPasswordChange: (String) -> Unit,
    onChangeAuthClick: () -> Unit,
    onSignClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        when {
            isLoading -> ProgressOverlay(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            )

            else -> Column(modifier = Modifier.padding(paddingValues)) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        space = Spacing.Medium,
                        alignment = Alignment.Bottom
                    ),
                    modifier = Modifier
                        .weight(0.3f)
                        .padding(Spacing.Large)
                ) {
                    Text(
                        text = stringResource(authScreenType.signLabelRes),
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = stringResource(authScreenType.messageLabelRes),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }

                AuthForm(
                    authScreenType = authScreenType,
                    email = email,
                    password = password,
                    secondaryPassword = secondaryPassword,
                    isEmailError = emailError != EmailError.NONE,
                    isPasswordError = passwordError != PasswordError.NONE,
                    isSecondaryPasswordError = secondaryPasswordError != PasswordError.NONE,
                    emailErrorLabel = stringResource(emailError.label),
                    passwordErrorLabel = stringResource(passwordError.label),
                    secondaryPasswordErrorLabel = stringResource(secondaryPasswordError.label),
                    onEmailChange = onEmailChange,
                    onPasswordChange = onPasswordChange,
                    onSecondaryPasswordChange = onSecondaryPasswordChange,
                    onChangeAuthClick = onChangeAuthClick,
                    onSignClick = onSignClick,
                    modifier = Modifier
                        .weight(0.7f)
                        .fillMaxWidth()
                        .padding(Spacing.Medium)

                )
            }
        }
    }
}