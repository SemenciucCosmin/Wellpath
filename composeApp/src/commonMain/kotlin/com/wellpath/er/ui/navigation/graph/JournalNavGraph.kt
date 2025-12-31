package com.wellpath.er.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.wellpath.er.feature.journal.route.JournalRoute
import com.wellpath.er.feature.journalpage.route.JournalPageRoute
import com.wellpath.er.ui.navigation.model.JournalNavDestination

fun NavGraphBuilder.journalNavGraph(navController: NavController) {
    composable<JournalNavDestination.Journal> {
        JournalRoute(navController)
    }

    composable<JournalNavDestination.JournalPage> { navEntry ->
        val args = navEntry.toRoute<JournalNavDestination.JournalPage>()
        JournalPageRoute(
            navController = navController,
            isReadOnly = args.isReadOnly
        )
    }
}
