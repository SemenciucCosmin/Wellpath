package com.wellpath.er.feature.exercises.exercises.route

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.wellpath.er.data.assignments.model.Assignment
import com.wellpath.er.domain.extensions.getContext
import com.wellpath.er.domain.extensions.showToast
import com.wellpath.er.domain.model.ToastLength
import com.wellpath.er.feature.exercises.exercises.viewmodel.ExercisesViewModel
import com.wellpath.er.ui.components.NavigationCard
import com.wellpath.er.ui.navigation.components.BottomBar
import com.wellpath.er.ui.navigation.model.ExercisesNavDestination
import com.wellpath.er.ui.theme.Pds
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import wellpath.composeapp.generated.resources.Res
import wellpath.composeapp.generated.resources.ic_student
import wellpath.composeapp.generated.resources.lbl_breathing
import wellpath.composeapp.generated.resources.lbl_breathing_description
import wellpath.composeapp.generated.resources.lbl_cbt
import wellpath.composeapp.generated.resources.lbl_cbt_description
import wellpath.composeapp.generated.resources.lbl_exercise_saved_successfully
import wellpath.composeapp.generated.resources.lbl_mindfulness
import wellpath.composeapp.generated.resources.lbl_mindfulness_description

@Composable
fun ExercisesRoute(
    isPatient: Boolean,
    navController: NavController,
) {
    val viewModel: ExercisesViewModel = koinViewModel()
    val context = getContext()
    val toastMessage = stringResource(Res.string.lbl_exercise_saved_successfully)

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
                isAddVisible = !isPatient,
                title = stringResource(Res.string.lbl_breathing),
                text = stringResource(Res.string.lbl_breathing_description),
                painter = painterResource(Res.drawable.ic_student),
                onClick = {
                    if (isPatient) {
                        navController.navigate(ExercisesNavDestination.Breathing)
                    }
                },
                onAddClick = {
                    if (!isPatient) {
                        viewModel.addAssignment(Assignment.Type.EXERCISE_BREATHING)
                        showToast(
                            context = context,
                            message = toastMessage,
                            length = ToastLength.SHORT
                        )
                    }
                }
            )

            NavigationCard(
                isAddVisible = !isPatient,
                title = stringResource(Res.string.lbl_cbt),
                text = stringResource(Res.string.lbl_cbt_description),
                painter = painterResource(Res.drawable.ic_student),
                onClick = {
                    if (isPatient) {
                        navController.navigate(ExercisesNavDestination.CBT)
                    }
                },
                onAddClick = {
                    if (!isPatient) {
                        viewModel.addAssignment(Assignment.Type.EXERCISE_CBT)
                        showToast(
                            context = context,
                            message = toastMessage,
                            length = ToastLength.SHORT
                        )
                    }
                }
            )

            NavigationCard(
                isAddVisible = !isPatient,
                title = stringResource(Res.string.lbl_mindfulness),
                text = stringResource(Res.string.lbl_mindfulness_description),
                painter = painterResource(Res.drawable.ic_student),
                onClick = {
                    if (isPatient) {
                        navController.navigate(ExercisesNavDestination.Mindfulness)
                    }
                },
                onAddClick = {
                    if (!isPatient) {
                        viewModel.addAssignment(Assignment.Type.EXERCISE_MINDFULNESS)
                        showToast(
                            context = context,
                            message = toastMessage,
                            length = ToastLength.SHORT
                        )
                    }
                }
            )
        }
    }
}
