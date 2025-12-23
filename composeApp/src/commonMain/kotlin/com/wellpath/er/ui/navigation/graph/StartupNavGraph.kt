package com.wellpath.er.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wellpath.er.feature.auth.route.AuthRoute
import com.wellpath.er.feature.startup.route.StartupRoute
import com.wellpath.er.ui.navigation.model.StartupNavDestination

fun NavGraphBuilder.StartupNavGraph(navController: NavController) {
    composable<StartupNavDestination.Startup> {
        StartupRoute(navController)
    }

    composable<StartupNavDestination.Auth> {
        AuthRoute(navController)
    }
}
