package com.wellpath.er.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.wellpath.er.feature.auth.route.AuthRoute
import com.wellpath.er.feature.dashboard.route.DashboardRoute
import com.wellpath.er.feature.exercises.route.ExercisesRoute
import com.wellpath.er.feature.startup.route.StartupRoute
import com.wellpath.er.ui.navigation.model.DashboardNavDestination
import com.wellpath.er.ui.navigation.model.ExercisesNavDestination
import com.wellpath.er.ui.navigation.model.JournalNavDestination
import com.wellpath.er.ui.navigation.model.StartupNavDestination

fun NavGraphBuilder.ExercisesNavGraph(navController: NavController) {
    composable<ExercisesNavDestination.Exercises> {
        ExercisesRoute(navController)
    }
}
