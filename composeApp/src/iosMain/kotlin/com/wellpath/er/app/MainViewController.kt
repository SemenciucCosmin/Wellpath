package com.wellpath.er.app

import androidx.compose.ui.window.ComposeUIViewController
import com.wellpath.er.di.KoinInitializer
import com.wellpath.er.ui.navigation.graph.AppNavGraph
import com.wellpath.er.ui.theme.WellpathTheme

@Suppress("FunctionNaming")
fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer.initKoin()
        AppInitializer.initApp()
    }
) {
    WellpathTheme {
        AppNavGraph(
            isPatient = true
        )
    }
}