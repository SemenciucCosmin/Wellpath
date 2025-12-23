package com.wellpath.er.ui.navigation.model

import kotlinx.serialization.Serializable

@Serializable
sealed class ExercisesNavDestination {

    @Serializable
    data object Exercises : ExercisesNavDestination()
}
