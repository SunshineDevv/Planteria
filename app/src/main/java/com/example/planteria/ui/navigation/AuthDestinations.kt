package com.example.planteria.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface AuthDestinations {
    @Serializable
    object SignUpScreen : AuthDestinations

    @Serializable
    object LogInScreen : AuthDestinations

    @Serializable
    object OnboardingScreen : AuthDestinations

    @Serializable
    object ResetPassScreen: AuthDestinations

    @Serializable
    object SuccessResetScreen: AuthDestinations
}