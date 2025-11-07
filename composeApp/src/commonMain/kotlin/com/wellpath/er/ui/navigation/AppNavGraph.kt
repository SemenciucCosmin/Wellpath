package com.wellpath.er.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wellpath.er.feature.auth.route.AuthRoute
import com.wellpath.er.feature.startup.route.StartupRoute
import com.wellpath.er.ui.navigation.model.AppNavDestination

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = AppNavDestination.Startup,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        composable<AppNavDestination.Startup> {
            StartupRoute(navController)
        }

        composable<AppNavDestination.Auth> {
            AuthRoute(navController)
        }

        composable<AppNavDestination.Welcome> {

        }
    }
}
