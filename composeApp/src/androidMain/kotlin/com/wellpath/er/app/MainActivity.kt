package com.wellpath.er.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.wellpath.er.ui.navigation.AppNavGraph
import com.wellpath.er.ui.theme.WellpathTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            WellpathTheme {
                AppNavGraph()
            }
        }
    }
}