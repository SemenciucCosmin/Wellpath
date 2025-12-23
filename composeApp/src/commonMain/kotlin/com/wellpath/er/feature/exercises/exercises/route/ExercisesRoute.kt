package com.wellpath.er.feature.exercises.exercises.route

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.wellpath.er.ui.components.NavigationCard
import com.wellpath.er.ui.navigation.components.BottomBar
import com.wellpath.er.ui.navigation.model.ExercisesNavDestination
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_student
import wellpath.composeapp.generated.resources.lbl_breathing
import wellpath.composeapp.generated.resources.lbl_breathing_description
import wellpath.composeapp.generated.resources.lbl_cbt
import wellpath.composeapp.generated.resources.lbl_cbt_description
import wellpath.composeapp.generated.resources.lbl_mindfulness
import wellpath.composeapp.generated.resources.lbl_mindfulness_description

@Composable
fun ExercisesRoute(navController: NavController) {
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.spacedBy(Pds.spacing.SMedium),
            modifier = Modifier
                .padding(paddingValues)
                .padding(Pds.spacing.Medium)
        ) {
            NavigationCard(
                title = stringResource(Res.string.lbl_breathing),
                text = stringResource(Res.string.lbl_breathing_description),
                painter = painterResource(Res.drawable.ic_student),
                onClick = { navController.navigate(ExercisesNavDestination.Breathing) },
            )

            NavigationCard(
                title = stringResource(Res.string.lbl_cbt),
                text = stringResource(Res.string.lbl_cbt_description),
                painter = painterResource(Res.drawable.ic_student),
                onClick = { navController.navigate(ExercisesNavDestination.CBT) },
            )

            NavigationCard(
                title = stringResource(Res.string.lbl_mindfulness),
                text = stringResource(Res.string.lbl_mindfulness_description),
                painter = painterResource(Res.drawable.ic_student),
                onClick = { navController.navigate(ExercisesNavDestination.Mindfulness) },
            )
        }
    }
}
