package com.wellpath.er.domain.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun getContext(): Any? {
    return LocalContext.current
}