package com.wellpath.er.feature.startup.route

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.wellpath.er.feature.startup.viewmodel.StartupViewModel
import com.wellpath.er.feature.startup.viewmodel.model.StartupEvent
import com.wellpath.er.ui.components.EventHandler
import com.wellpath.er.ui.components.ProgressOverlay
import com.wellpath.er.ui.navigation.model.AppNavDestination
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun StartupRoute(navController: NavController) {
    val viewModel: StartupViewModel = koinViewModel()

    Scaffold { paddingValues ->
        ProgressOverlay(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        )
    }

    EventHandler(viewModel.events) {event ->
        when (event) {
            StartupEvent.NOT_SIGNED_IN -> navController.navigate(AppNavDestination.Auth)
            StartupEvent.SIGNED_IN -> navController.navigate(AppNavDestination.Welcome)
        }
    }
}