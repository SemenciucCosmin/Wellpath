package com.wellpath.er.ui.navigation.model

import kotlinx.serialization.Serializable

@Serializable
sealed class ExercisesNavDestination {

    @Serializable
    data object Exercises : ExercisesNavDestination()

    @Serializable
    data object Breathing : ExercisesNavDestination()

    @Serializable
    data class CBT(val stageId: Int) : ExercisesNavDestination()

    @Serializable
    data object CbtFinish : ExercisesNavDestination()

    @Serializable
    data object Mindfulness : ExercisesNavDestination()
}
