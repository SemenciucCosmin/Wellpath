package com.wellpath.er.ui.navigation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import com.wellpath.er.feature.dashboard.route.DashboardRoute
import com.wellpath.er.ui.navigation.model.StartupNavDestination
import com.wellpath.er.ui.navigation.model.BottomBarItem
import com.wellpath.er.ui.navigation.model.DashboardNavDestination
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

/**
 * Composable function that displays the bottom navigation bar for the timetable.
 *
 * @param navController The NavController used for navigation.
 */
@Composable
fun BottomBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomAppBar(containerColor = MaterialTheme.colorScheme.surfaceContainerLow) {
        BottomBarItem.entries.forEach { timetableBottomBarItem ->
            val destination = timetableBottomBarItem.destination
            val isSelected = currentDestination?.hasRoute(destination::class) == true

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(timetableBottomBarItem.destination) {
                        popUpTo(DashboardNavDestination.Dashboard) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(Pds.icon.SMedium),
                        painter = painterResource(timetableBottomBarItem.icon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(timetableBottomBarItem.labelRes))
                }
            )
        }
    }
}
