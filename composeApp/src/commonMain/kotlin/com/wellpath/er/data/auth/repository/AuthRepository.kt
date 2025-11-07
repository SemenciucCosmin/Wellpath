package com.wellpath.er.data.auth.repository

import com.wellpath.er.data.auth.model.FirebaseUser
import kotlinx.coroutines.flow.Flow

/**
 * Repository class for user authentication actions and information
 */
interface AuthRepository {

    /**
     * Returns a flow with the logged [FirebaseUser] or null is no user is logged in
     */
    suspend fun getCurrentUserFlow(): Flow<FirebaseUser?>

    /**
     * Returns the logged [FirebaseUser] or null is no user is logged in
     */
    fun getCurrentUser(): FirebaseUser?

    /**
     * Uses the [email] and [password] from user to log in a firebase account
     */
    suspend fun signIn(email: String, password: String)

    /**
     * Uses the [email] and [password] from user to create a firebase account
     */
    suspend fun signUp(email: String, password: String)

    /**
     * Sign the user out
     */
    suspend fun signOut()

    /**
     * Deletes the user's account
     */
    suspend fun deleteAccount(): Boolean
}
