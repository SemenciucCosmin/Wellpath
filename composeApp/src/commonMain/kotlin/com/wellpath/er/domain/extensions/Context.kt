package com.wellpath.er.domain.extensions

import androidx.compose.runtime.Composable

/**
 * Composable function for getting the Context from specific platform
 */
@Composable
expect fun getContext(): Any?