package com.wellpath.er.feature.journalpage.route

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wellpath.er.feature.journalpage.components.MoodSlider
import com.wellpath.er.feature.journalpage.viewmodel.JournalPageViewModel
import com.wellpath.er.ui.components.TitleBar
import com.wellpath.er.ui.model.TitleBarMenuItem
import com.wellpath.er.ui.theme.Pds
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_left_arrow
import wellpath.composeapp.generated.resources.lbl_journal_entry_description
import wellpath.composeapp.generated.resources.lbl_save

@Composable
fun JournalPageRoute(
    navController: NavController,
    isReadOnly: Boolean,
) {
    val viewModel: JournalPageViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TitleBar(
                label = uiState.date,
                actionIcon = painterResource(Res.drawable.ic_left_arrow),
                onAction = navController::navigateUp,
                menuItems = listOfNotNull(
                    TitleBarMenuItem(
                        label = stringResource(Res.string.lbl_save),
                        action = {
                            viewModel.saveJournalPage()
                            navController.navigateUp()
                        },
                    ).takeIf { !isReadOnly }
                ).toImmutableList()
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(Pds.spacing.Medium)
        ) {
            MoodSlider(
                value = uiState.moodScore,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    if (!isReadOnly) viewModel.changeMoodScore(it)
                },
            )

            Spacer(modifier = Modifier.size(Pds.spacing.Large))

            HorizontalDivider()

            Spacer(modifier = Modifier.size(Pds.spacing.Large))

            Text(
                text = stringResource(Res.string.lbl_journal_entry_description),
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.size(Pds.spacing.XSmall))

            OutlinedTextField(
                value = uiState.journalEntry,
                onValueChange = {
                    if (!isReadOnly) viewModel.changeJournalEntry(it)
                },
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}