package com.wellpath.er.app

import androidx.compose.ui.window.ComposeUIViewController
import com.wellpath.er.di.KoinInitializer
import com.wellpath.er.ui.navigation.AppNavGraph
import com.wellpath.er.ui.theme.WellpathTheme

fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer.initKoin()
        AppInitializer.initApp()
    }
) {
    WellpathTheme {
        AppNavGraph()
    }
}