package com.wellpath.er.ui.navigation.graph

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.wellpath.er.ui.navigation.model.StartupNavDestination

@Composable
fun AppNavGraph(
    isPatient: Boolean,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = StartupNavDestination.Startup,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        startupNavGraph(navController)
        dashboardNavGraph(isPatient, navController)
        patientNavGraph(navController)
        journalNavGraph(isPatient, navController)
        exercisesNavGraph(isPatient, navController)
    }
}
