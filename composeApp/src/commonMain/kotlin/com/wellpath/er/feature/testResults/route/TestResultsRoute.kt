package com.wellpath.er.feature.testResults.route

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.wellpath.er.feature.test.model.labelRes
import com.wellpath.er.feature.testResults.viewmodel.TestResultsViewModel
import com.wellpath.er.ui.components.TitleBar
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_left_arrow
import wellpath.composeapp.generated.resources.ic_right_arrow
import wellpath.composeapp.generated.resources.lbl_test_bfi_results

@Suppress("MagicNumber")
@Composable
fun TestResultsRoute(
    navController: NavController,
) {
    val viewModel: TestResultsViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TitleBar(
                label = stringResource(Res.string.lbl_test_bfi_results),
                actionIcon = painterResource(Res.drawable.ic_left_arrow),
                onAction = navController::navigateUp,
            )
        }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.spacedBy(Pds.spacing.Medium),
            modifier = Modifier
                .padding(paddingValues)
                .padding(Pds.spacing.Medium)
                .fillMaxSize()
        ) {
            HorizontalDivider()

            uiState.results.forEach { (dimension, score) ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(dimension.labelRes),
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(0.6f)
                    )

                    Icon(
                        painter = painterResource(Res.drawable.ic_right_arrow),
                        contentDescription = null,
                        modifier = Modifier.weight(0.4f)
                    )

                    Text(
                        text = score.toString(),
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }

                HorizontalDivider()
            }
        }
    }
}