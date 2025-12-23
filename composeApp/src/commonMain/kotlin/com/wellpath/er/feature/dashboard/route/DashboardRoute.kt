package com.wellpath.er.feature.dashboard.route

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.wellpath.er.feature.dashboard.viewmodel.DashboardViewModel
import com.wellpath.er.ui.navigation.components.BottomBar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DashboardRoute(navController: NavController) {
    val viewModel: DashboardViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { paddingValues ->

    }
}