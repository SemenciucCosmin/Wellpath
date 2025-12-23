package com.wellpath.er.feature.exercises.route

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.wellpath.er.feature.journal.viewmodel.JournalViewModel
import com.wellpath.er.ui.navigation.components.BottomBar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ExercisesRoute(navController: NavController) {
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { paddingValues ->

    }
}
