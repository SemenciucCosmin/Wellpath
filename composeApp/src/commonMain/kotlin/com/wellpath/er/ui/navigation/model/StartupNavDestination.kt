package com.wellpath.er.ui.navigation.model

import kotlinx.serialization.Serializable

@Serializable
sealed class StartupNavDestination {

    @Serializable
    data object Startup : StartupNavDestination()

    @Serializable
    data object Auth : StartupNavDestination()
}
