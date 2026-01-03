package com.wellpath.er.feature.journal.route

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.wellpath.er.feature.journal.components.JournalCalendar
import com.wellpath.er.feature.journal.components.JournalPagingControl
import com.wellpath.er.feature.journal.components.JournalWriteButton
import com.wellpath.er.feature.journal.viewmodel.JournalViewModel
import com.wellpath.er.feature.journal.viewmodel.model.JournalUiState
import com.wellpath.er.ui.navigation.components.BottomBar
import com.wellpath.er.ui.navigation.model.JournalNavDestination
import com.wellpath.er.ui.theme.Pds
import org.koin.compose.viewmodel.koinViewModel
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Composable
fun JournalRoute(navController: NavController) {
    val viewModel: JournalViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.spacedBy(Pds.spacing.XLarge),
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .padding(paddingValues)
                .padding(Pds.spacing.Medium)
        ) {
            JournalPagingControl(
                label = uiState.selectedDate,
                onLeftControlClick = { viewModel.movePage(JournalUiState.PagingDirection.LEFT) },
                onRightControlClick = { viewModel.movePage(JournalUiState.PagingDirection.RIGHT) }
            )

            JournalCalendar(
                currentJournalRecordId = uiState.currentJournalRecordId,
                journalRecords = uiState.filteredRecords,
                onJournalRecordClick = { record ->
                    val destination = JournalNavDestination.JournalPage(
                        journalRecordId = "${record.day}${record.month}${record.year}",
                        isReadOnly = true
                    )

                    navController.navigate(destination)
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            JournalWriteButton(
                onClick = {
                    val destination = JournalNavDestination.JournalPage(
                        journalRecordId = uiState.currentJournalRecordId,
                        isReadOnly = false
                    )

                    navController.navigate(destination)
                }
            )
        }
    }
}