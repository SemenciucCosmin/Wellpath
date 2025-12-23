package com.wellpath.er.ui.navigation.model

import kotlinx.serialization.Serializable

@Serializable
sealed class DashboardNavDestination {

    @Serializable
    data object Dashboard : DashboardNavDestination()
}
