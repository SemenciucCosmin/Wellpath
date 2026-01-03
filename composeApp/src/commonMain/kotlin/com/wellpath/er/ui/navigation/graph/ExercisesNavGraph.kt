package com.wellpath.er.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wellpath.er.feature.exercises.breathing.route.BreathingRoute
import com.wellpath.er.feature.exercises.exercises.route.ExercisesRoute
import com.wellpath.er.ui.navigation.model.ExercisesNavDestination

fun NavGraphBuilder.exercisesNavGraph(
    isPatient: Boolean,
    navController: NavController
) {
    composable<ExercisesNavDestination.Exercises> {
        ExercisesRoute(
            isPatient = isPatient,
            navController = navController
        )
    }

    composable<ExercisesNavDestination.Breathing> {
        BreathingRoute(navController)
    }

    composable<ExercisesNavDestination.CBT> {
    }

    composable<ExercisesNavDestination.Mindfulness> {
    }
}
