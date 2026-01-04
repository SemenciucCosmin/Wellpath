package com.wellpath.er.feature.patients.route

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.wellpath.er.feature.patients.viewmodel.PatientsViewModel
import com.wellpath.er.ui.components.TitleBar
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_check
import wellpath.composeapp.generated.resources.ic_left_arrow
import wellpath.composeapp.generated.resources.lbl_patients

@Composable
fun PatientsRoute(navController: NavController) {
    val viewModel: PatientsViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TitleBar(
                label = stringResource(Res.string.lbl_patients),
                actionIcon = painterResource(Res.drawable.ic_left_arrow),
                onAction = navController::navigateUp,
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(Pds.spacing.Medium),
            verticalArrangement = Arrangement.spacedBy(Pds.spacing.Medium)
        ) {
            items(uiState.patients) { patient ->
                Column(verticalArrangement = Arrangement.spacedBy(Pds.spacing.Medium)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            viewModel.selectPatient(patient.id)
                            navController.navigateUp()
                        }
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(Pds.spacing.XXSmall)
                        ) {
                            Text(
                                text = patient.name,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Text(
                                text = "${patient.age} | ${patient.gender}",
                                style = MaterialTheme.typography.bodyLarge,
                            )
                        }

                        if (patient.id == uiState.selectedPatientId) {
                            Icon(
                                painter = painterResource(Res.drawable.ic_check),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(Pds.icon.Medium)
                            )
                        }
                    }

                    HorizontalDivider()
                }
            }
        }
    }
}