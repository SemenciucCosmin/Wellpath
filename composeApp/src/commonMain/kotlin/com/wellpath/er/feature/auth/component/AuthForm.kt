package com.wellpath.er.feature.auth.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.wellpath.er.domain.extensions.BLANK
import com.wellpath.er.feature.auth.model.AuthScreenType
import com.wellpath.er.ui.components.PrimaryButton
import com.wellpath.er.ui.dimension.Spacing
import org.jetbrains.compose.resources.stringResource

/**
 * Generic form for authentication, customizable between sing in and sign up
 */
@Composable
fun AuthForm(
    authScreenType: AuthScreenType,
    email: String,
    password: String,
    secondaryPassword: String,
    isEmailError: Boolean,
    isPasswordError: Boolean,
    isSecondaryPasswordError: Boolean,
    emailErrorLabel: String,
    passwordErrorLabel: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSecondaryPasswordChange: (String) -> Unit,
    onChangeAuthClick: () -> Unit,
    onSignClick: () -> Unit,
    modifier: Modifier = Modifier,
    secondaryPasswordErrorLabel: String = String.BLANK,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        EmailTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            isError = isEmailError,
            supportingText = emailErrorLabel,
            onValueChange = onEmailChange
        )

        Spacer(modifier = Modifier.height(Spacing.Medium))

        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            isError = isPasswordError,
            supportingText = passwordErrorLabel,
            onValueChange = onPasswordChange
        )

        AnimatedVisibility(visible = authScreenType == AuthScreenType.SIGN_UP) {
            Column {
                Spacer(modifier = Modifier.height(Spacing.Medium))

                PasswordTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = secondaryPassword,
                    isError = isSecondaryPasswordError,
                    supportingText = secondaryPasswordErrorLabel,
                    onValueChange = onSecondaryPasswordChange
                )
            }
        }

        Spacer(modifier = Modifier.height(Spacing.Large))

        PrimaryButton(
            onClick = onSignClick,
            text = stringResource(authScreenType.signLabelRes),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(Spacing.Large))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(authScreenType.redirectLabelRes),
                color = MaterialTheme.colorScheme.onBackground
            )

            TextButton(onClick = onChangeAuthClick) {
                Text(
                    text = stringResource(authScreenType.redirectSignLabelRes),
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
