package com.wellpath.er.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.wellpath.er.feature.exercises.breathing.route.BreathingRoute
import com.wellpath.er.feature.exercises.cbt.model.CbtStage
import com.wellpath.er.feature.exercises.cbt.route.CbtFinishRoute
import com.wellpath.er.feature.exercises.cbt.route.CbtRoute
import com.wellpath.er.feature.exercises.exercises.route.ExercisesRoute
import com.wellpath.er.feature.exercises.mindfulness.route.MindfulnessRoute
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

    composable<ExercisesNavDestination.CBT> { navEntry ->
        val args = navEntry.toRoute<ExercisesNavDestination.CBT>()
        val stage = CbtStage.getById(args.stageId)

        CbtRoute(
            navController = navController,
            stage = stage,
        )
    }

    composable<ExercisesNavDestination.CbtFinish> {
        CbtFinishRoute(navController)
    }

    composable<ExercisesNavDestination.Mindfulness> {
        MindfulnessRoute(navController)
    }
}
