package com.wellpath.er.ui.navigation.model

import kotlinx.serialization.Serializable

@Serializable
sealed class JournalNavDestination {

    @Serializable
    data object Journal : JournalNavDestination()

    @Serializable
    data object JournalPage : JournalNavDestination()
}
