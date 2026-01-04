package com.wellpath.er.ui.navigation.model

import kotlinx.serialization.Serializable

/**
 * Sealed class for all possible navigation destination from onboarding flow.
 */
@Serializable
sealed interface TestNavDestination {

    @Serializable
    data class Test(val index: Int) : TestNavDestination

    @Serializable
    data object TestResults : TestNavDestination
}