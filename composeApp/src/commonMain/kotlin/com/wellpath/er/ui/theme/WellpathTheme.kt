package com.wellpath.er.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun WellpathTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content:
    @Composable()
    () -> Unit,
) {
    val colorScheme = when {
        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
