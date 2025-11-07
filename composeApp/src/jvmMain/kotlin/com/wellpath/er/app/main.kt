package com.wellpath.er.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.wellpath.er.di.KoinInitializer
import com.wellpath.er.ui.navigation.AppNavGraph
import com.wellpath.er.ui.theme.WellpathTheme

fun main() = application {
    KoinInitializer.initKoin()
    AppInitializer.initApp()

    Window(
        onCloseRequest = ::exitApplication,
        title = "Wellpath",
    ) {
        WellpathTheme {
            AppNavGraph()
        }
    }
}