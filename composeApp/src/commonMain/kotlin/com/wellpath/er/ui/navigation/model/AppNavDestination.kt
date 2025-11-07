package com.wellpath.er.ui.navigation.model

import kotlinx.serialization.Serializable

/**
 * All feedback nav destinations
 */
@Serializable
sealed class AppNavDestination {

    @Serializable
    data object Startup : AppNavDestination()

    @Serializable
    data object Auth : AppNavDestination()

    @Serializable
    data object Welcome : AppNavDestination()
}
