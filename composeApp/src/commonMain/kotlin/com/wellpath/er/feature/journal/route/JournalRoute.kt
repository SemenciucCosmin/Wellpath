package com.wellpath.er.feature.journal.route

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.wellpath.er.feature.journal.viewmodel.JournalViewModel
import com.wellpath.er.ui.navigation.components.BottomBar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun JournalRoute(navController: NavController) {
    val viewModel: JournalViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { paddingValues ->
    }
}