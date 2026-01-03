package com.wellpath.er.ui.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wellpath.er.feature.patients.route.PatientsRoute
import com.wellpath.er.ui.navigation.model.PatientNavDestination

fun NavGraphBuilder.patientNavGraph(navController: NavController) {
    composable<PatientNavDestination.Patients> {
        PatientsRoute(navController)
    }
}
