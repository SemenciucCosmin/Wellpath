package com.wellpath.er.feature.auth.route

import androidx.compose.foundation.layout.imePadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.wellpath.er.feature.auth.component.AuthScreen
import com.wellpath.er.feature.auth.viewmodel.AuthViewModel
import com.wellpath.er.feature.auth.viewmodel.model.AuthUiState
import com.wellpath.er.ui.components.EventHandler
import com.wellpath.er.ui.navigation.model.DashboardNavDestination
import org.koin.compose.viewmodel.koinViewModel

/**
 * Route for authentication feature
 */
@Composable
fun AuthRoute(navController: NavController) {
    val viewModel = koinViewModel<AuthViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    AuthScreen(
        modifier = Modifier.imePadding(),
        authScreenType = uiState.authScreenType,
        isLoading = uiState.isLoading,
        email = uiState.email,
        password = uiState.password,
        secondaryPassword = uiState.secondaryPassword,
        emailError = uiState.emailError,
        passwordError = uiState.passwordError,
        secondaryPasswordError = uiState.secondaryPasswordError,
        snackbarHostState = viewModel.snackbarHostState,
        onEmailChange = viewModel::changeEmail,
        onPasswordChange = viewModel::changePassword,
        onSecondaryPasswordChange = viewModel::changeSecondaryPassword,
        onChangeAuthClick = viewModel::changeAuth,
        onSignClick = viewModel::sign,
    )

    EventHandler(viewModel.events) { event ->
        when (event) {
            AuthUiState.AuthEvent.SIGNED -> {
                viewModel.unregisterEvent(event)
                navController.navigate(DashboardNavDestination.Dashboard)
            }
        }
    }
}
