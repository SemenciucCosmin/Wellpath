package com.wellpath.er.ui.navigation.model

import kotlinx.serialization.Serializable

@Serializable
sealed class PatientNavDestination {

    @Serializable
    data object Patients : PatientNavDestination()
}
