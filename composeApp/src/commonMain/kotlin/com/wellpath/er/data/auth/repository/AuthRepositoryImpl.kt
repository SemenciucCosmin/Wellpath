package com.wellpath.er.data.auth.repository

import com.wellpath.er.data.auth.model.FirebaseUser
import com.wellpath.er.domain.extensions.BLANK
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest

/**
 * Repository class for user authentication actions and information
 */
class AuthRepositoryImpl : AuthRepository {

    /**
     * Returns a flow with the logged [FirebaseUser] or null is no user is logged in
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getCurrentUserFlow(): Flow<FirebaseUser?> {
        return Firebase.auth.authStateChanged.mapLatest { firebaseUser ->
            firebaseUser?.let {
                val email = firebaseUser.email ?: return@let null
                val displayName = firebaseUser.displayName ?: String.BLANK

                FirebaseUser(
                    id = firebaseUser.uid,
                    email = email,
                    provider = firebaseUser.providerId,
                    displayName = displayName,
                    isAnonymous = firebaseUser.isAnonymous
                )
            }
        }
    }

    /**
     * Returns the logged [FirebaseUser] or null is no user is logged in
     */
    override fun getCurrentUser(): FirebaseUser? {
        return Firebase.auth.currentUser?.let { firebaseUser ->
            val email = firebaseUser.email ?: return@let null
            val displayName = firebaseUser.displayName ?: String.BLANK

            FirebaseUser(
                id = firebaseUser.uid,
                email = email,
                provider = firebaseUser.providerId,
                displayName = displayName,
                isAnonymous = firebaseUser.isAnonymous
            )
        }
    }

    /**
     * Uses the [email] and [password] from user to log in a firebase account
     */
    override suspend fun signIn(email: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(email, password)
    }

    /**
     * Uses the [email] and [password] from user to create a firebase account
     */
    override suspend fun signUp(email: String, password: String) {
        Firebase.auth.createUserWithEmailAndPassword(email, password)
    }

    /**
     * Sign the user out
     */
    override suspend fun signOut() {
        Firebase.auth.signOut()
    }

    /**
     * Deletes the user's account
     */
    override suspend fun deleteAccount(): Boolean {
        val firebaseUser = Firebase.auth.currentUser ?: return false
        firebaseUser.delete()
        return true
    }
}
