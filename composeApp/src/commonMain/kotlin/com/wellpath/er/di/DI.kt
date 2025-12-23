package com.wellpath.er.di

import com.wellpath.er.data.auth.di.authDataModule
import com.wellpath.er.feature.auth.di.authFeatureModule
import com.wellpath.er.feature.dashboard.di.dashboardFeatureModule
import com.wellpath.er.feature.journal.di.journalFeatureModule
import com.wellpath.er.feature.startup.di.startupFeatureModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

/**
 * Provides the common Koin module for the Orar UBB FMI application.
 * This module includes all necessary dependencies for the application to function correctly.
 */
fun commonModule() = module {
    // COMMON
    single { CoroutineScope(SupervisorJob() + Dispatchers.Default) }

    includes(authDataModule())
    includes(authFeatureModule())
    includes(dashboardFeatureModule())
    includes(journalFeatureModule())
    includes(startupFeatureModule())
}
