package com.wellpath.er.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.wellpath.er.feature.test.route.TestRoute
import com.wellpath.er.feature.testResults.route.TestResultsRoute
import com.wellpath.er.ui.navigation.model.TestNavDestination

fun NavGraphBuilder.testNavGraph(
    navController: NavController,
) {
    composable<TestNavDestination.Test> { navBackStackEntry ->
        val args = navBackStackEntry.toRoute<TestNavDestination.Test>()

        TestRoute(
            index = args.index,
            navController = navController
        )
    }

    composable<TestNavDestination.TestResults> {
        TestResultsRoute(navController)
    }
}
