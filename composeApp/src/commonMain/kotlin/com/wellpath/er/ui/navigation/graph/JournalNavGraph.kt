package com.wellpath.er.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wellpath.er.feature.journal.route.JournalRoute
import com.wellpath.er.ui.navigation.model.JournalNavDestination

fun NavGraphBuilder.journalNavGraph(navController: NavController) {
    composable<JournalNavDestination.Journal> {
        JournalRoute(navController)
    }

    composable<JournalNavDestination.JournalPage> {
    }
}
