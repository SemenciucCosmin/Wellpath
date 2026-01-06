package com.wellpath.er.feature.exercises.cbt.route

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.wellpath.er.domain.extensions.BLANK
import com.wellpath.er.feature.exercises.cbt.model.CbtStage
import com.wellpath.er.ui.components.TitleBar
import com.wellpath.er.ui.dimension.Radius
import com.wellpath.er.ui.dimension.Spacing
import com.wellpath.er.ui.navigation.model.ExercisesNavDestination
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_close
import wellpath.composeapp.generated.resources.ic_left_arrow
import wellpath.composeapp.generated.resources.ic_right_arrow
import wellpath.composeapp.generated.resources.lbl_back
import wellpath.composeapp.generated.resources.lbl_next

@Composable
fun CbtRoute(
    navController: NavController,
    stage: CbtStage,
) {
    var comment by remember { mutableStateOf(String.BLANK) }

    Scaffold(
        topBar = {
            TitleBar(
                label = stringResource(stage.titleRes),
                actionIcon = painterResource(Res.drawable.ic_close),
                onAction = {
                    navController.popBackStack(
                        route = ExercisesNavDestination.CBT(CbtStage.SITUATION.id),
                        inclusive = true
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(Pds.spacing.Medium)
        ) {
            Spacer(modifier = Modifier.size(Pds.spacing.Medium))

            Text(
                text = stringResource(stage.instructionRes),
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.size(Pds.spacing.Large))

            OutlinedTextField(
                value = comment,
                onValueChange = { comment = it },
                shape = MaterialTheme.shapes.large,
                placeholder = {
                    Text(text = stringResource(stage.clueRes))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 400.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = navController::navigateUp,
                    shape = RoundedCornerShape(Radius.Large),
                    content = {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(Spacing.Small),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.ic_left_arrow),
                                contentDescription = null
                            )

                            Text(
                                text = stringResource(Res.string.lbl_back),
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        }
                    }
                )

                Button(
                    shape = RoundedCornerShape(Radius.Large),
                    onClick = {
                        when (stage) {
                            CbtStage.RE_RATE_EMOTION -> navController.navigate(
                                ExercisesNavDestination.CbtFinish
                            )

                            else -> navController.navigate(
                                ExercisesNavDestination.CBT(stage.id.inc())
                            )
                        }
                    },
                    content = {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(Spacing.Small),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(Res.string.lbl_next),
                                style = MaterialTheme.typography.bodyMedium,
                            )

                            Icon(
                                painter = painterResource(Res.drawable.ic_right_arrow),
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        }
    }
}