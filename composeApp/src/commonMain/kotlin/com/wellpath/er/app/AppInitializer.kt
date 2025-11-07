package com.wellpath.er.app

import kotlinx.coroutines.CoroutineScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.getValue

/**
 * Initializer class for all core shared processes.
 */
object AppInitializer : KoinComponent {

    private val coroutineScope: CoroutineScope by inject()

    fun initApp() {

    }
}