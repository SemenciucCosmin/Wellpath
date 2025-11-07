package com.wellpath.er.app

import android.app.Application
import com.google.firebase.FirebaseApp
import com.wellpath.er.di.KoinInitializer
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.initialize
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.getValue

/**
 * Main application class for the Orar UBB FMI application.
 * This class initializes Koin for dependency injection.
 */
class WellpathApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer.initKoin {
            androidContext(this@WellpathApplication)
        }

        val firebaseOptions = FirebaseOptions(
            applicationId = APPLICATION_ID,
            apiKey = API_KEY,
            projectId = PROJECT_ID,
            storageBucket = STORAGE_BUCKET
        )

        Firebase.initialize(this@WellpathApplication, firebaseOptions, APP_NAME)
        AppInitializer.initApp()
    }

    companion object {
        private const val APP_NAME = "Wellpath"
        private const val APPLICATION_ID = "1:14464023107:android:162a230f422deb7bcaf2f6"
        private const val API_KEY = "AIzaSyCJs1PE1myxTHFfn3jleZFZbsEoWyVOFiE"
        private const val PROJECT_ID = "wellpath-20cb8"
        private const val STORAGE_BUCKET = "wellpath-20cb8.firebasestorage.app"
    }
}
