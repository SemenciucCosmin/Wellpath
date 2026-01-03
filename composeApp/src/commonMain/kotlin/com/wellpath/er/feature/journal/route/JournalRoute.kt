package com.wellpath.er.feature.journal.route

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.wellpath.er.feature.journal.viewmodel.JournalViewModel
import com.wellpath.er.feature.journal.viewmodel.model.JournalUiState
import com.wellpath.er.ui.navigation.components.BottomBar
import com.wellpath.er.ui.navigation.model.JournalNavDestination
import com.wellpath.er.ui.theme.Pds
import org.koin.compose.viewmodel.koinViewModel

private const val COLUMNS_COUNT = 7

@Composable
fun JournalRoute(navController: NavController) {
    val viewModel: JournalViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.spacedBy(Pds.spacing.XLarge),
            modifier = Modifier
                .padding(paddingValues)
                .padding(Pds.spacing.Medium)
        ) {
            JournalPagingControl(
                label = uiState.selectedDate,
                onLeftControlClick = { viewModel.movePage(JournalUiState.PagingDirection.LEFT) },
                onRightControlClick = { viewModel.movePage(JournalUiState.PagingDirection.RIGHT) }
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(COLUMNS_COUNT),
                verticalArrangement = Arrangement.spacedBy(Pds.spacing.SMedium),
                horizontalArrangement = Arrangement.spacedBy(Pds.spacing.SMedium),
            ) {
                items(uiState.filteredRecords) { record ->
                    Card(
                        modifier = Modifier.height(100.dp),
                        shape = MaterialTheme.shapes.small,
                        onClick = {
                            val destination = JournalNavDestination.JournalPage(
                                journalRecordId = "${record.day}${record.month}${record.year}",
                                isReadOnly = true
                            )

                            navController.navigate(destination)
                        }
                    ) {
                        Column(
                            modifier = Modifier.padding(Pds.spacing.XSmall),
                            verticalArrangement = Arrangement.spacedBy(Pds.spacing.XSmall)
                        ) {
                            Text(
                                text = record.day.toString(),
                                style = MaterialTheme.typography.labelMedium,
                            )

                            record.assignments.forEach { assignment ->
                                Box(
                                    modifier = Modifier
                                        .background(assignment.type.color)
                                        .height(Pds.spacing.Small)
                                        .fillMaxWidth()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}