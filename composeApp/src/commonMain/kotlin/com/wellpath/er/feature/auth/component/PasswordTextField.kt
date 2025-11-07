package com.wellpath.er.feature.auth.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.wellpath.er.ui.dimension.IconSize
import com.wellpath.er.ui.dimension.Radius
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_password_hidden
import wellpath.composeapp.generated.resources.ic_password_visible
import wellpath.composeapp.generated.resources.lbl_accessibility_password_hidden
import wellpath.composeapp.generated.resources.lbl_accessibility_password_visible
import wellpath.composeapp.generated.resources.lbl_password

/**
 * Custom text field for password input
 */
@Composable
fun PasswordTextField(
    value: String,
    isError: Boolean,
    supportingText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        isError = isError,
        singleLine = true,
        shape = RoundedCornerShape(Radius.Large),
        visualTransformation = when {
            isPasswordVisible -> VisualTransformation.None
            else -> PasswordVisualTransformation()
        },
        supportingText = when {
            supportingText.isEmpty() -> null
            else -> {
                { Text(text = supportingText) }
            }
        },
        placeholder = {
            Text(text = stringResource(Res.string.lbl_password))
        },
        trailingIcon = {
            Icon(
                contentDescription = when {
                    isPasswordVisible -> {
                        stringResource(Res.string.lbl_accessibility_password_visible)
                    }

                    else -> {
                        stringResource(Res.string.lbl_accessibility_password_hidden)
                    }
                },
                painter = when {
                    isPasswordVisible -> painterResource(Res.drawable.ic_password_visible)
                    else -> painterResource(Res.drawable.ic_password_hidden)
                },
                modifier = Modifier
                    .size(IconSize.Small)
                    .clickable { isPasswordVisible = !isPasswordVisible }
            )
        }
    )
}
