package com.wellpath.er.feature.dashboard.route

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.wellpath.er.data.assignments.model.Assignment
import com.wellpath.er.feature.assignment.components.AssignmentItem
import com.wellpath.er.feature.dashboard.viewmodel.DashboardViewModel
import com.wellpath.er.ui.navigation.components.BottomBar
import com.wellpath.er.ui.navigation.model.ExercisesNavDestination
import com.wellpath.er.ui.navigation.model.JournalNavDestination
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.lbl_dashboard

@Composable
fun DashboardRoute(navController: NavController) {
    val viewModel: DashboardViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = { BottomBar(navController) },
    ) { paddingValues ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Pds.spacing.Medium),
            modifier = Modifier
                .padding(paddingValues)
                .padding(Pds.spacing.Medium)
        ) {
            item {
                Text(
                    text = stringResource(Res.string.lbl_dashboard),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            item { Spacer(modifier = Modifier.size(Pds.spacing.Medium)) }

            items(uiState.assignments) { assignment ->
                AssignmentItem(
                    assignment = assignment,
                    onClick = {
                        if (assignment.isCompleted) return@AssignmentItem
                        when (assignment.type) {
                            Assignment.Type.JOURNAL_PAGE -> {
                                val destination = JournalNavDestination.JournalPage(
                                    journalRecordId = uiState.currentJournalRecordId,
                                    isReadOnly = false
                                )

                                navController.navigate(destination)
                            }

                            Assignment.Type.EXERCISE_BREATHING -> {
                                navController.navigate(ExercisesNavDestination.Breathing)
                            }

                            Assignment.Type.EXERCISE_MINDFULNESS -> {
                                navController.navigate(ExercisesNavDestination.Mindfulness)
                            }
                        }
                    }
                )
            }
        }
    }
}