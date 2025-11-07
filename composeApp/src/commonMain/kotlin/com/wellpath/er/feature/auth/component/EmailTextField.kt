package com.wellpath.er.feature.auth.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wellpath.er.ui.dimension.Radius
import org.jetbrains.compose.resources.stringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_email

/**
 * Custom text field for email input
 */
@Composable
fun EmailTextField(
    value: String,
    isError: Boolean,
    supportingText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        isError = isError,
        singleLine = true,
        shape = RoundedCornerShape(Radius.Large),
        supportingText = when {
            supportingText.isEmpty() -> null
            else -> {
                { Text(text = supportingText) }
            }
        },
        placeholder = {
            Text(text = stringResource(Res.string.lbl_email))
        }
    )
}
