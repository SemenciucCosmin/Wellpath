package com.wellpath.er.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wellpath.er.feature.dashboard.route.DashboardRoute
import com.wellpath.er.ui.navigation.model.DashboardNavDestination

fun NavGraphBuilder.dashboardNavGraph(navController: NavController) {
    composable<DashboardNavDestination.Dashboard> {
        DashboardRoute(navController)
    }
}
