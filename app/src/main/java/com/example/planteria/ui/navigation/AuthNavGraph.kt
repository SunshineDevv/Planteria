package com.example.planteria.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planteria.auth.screens.LogInScreen
import com.example.planteria.auth.screens.OnboardingScreen
import com.example.planteria.auth.screens.ResetPassScreen
import com.example.planteria.auth.screens.SignUpScreen
import com.example.planteria.auth.screens.SuccessResetScreen

@Composable
fun AuthNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AuthDestinations.OnboardingScreen,
    ) {
        composable<AuthDestinations.OnboardingScreen> {
            OnboardingScreen(
                onNavigateTo = { navController.navigate(it) }
            )
        }

        composable<AuthDestinations.LogInScreen> {
            LogInScreen(
                onNavigateTo = { navController.navigate(it) }
            )
        }

        composable<AuthDestinations.SignUpScreen> {
            SignUpScreen(
                onNavigateTo = { navController.navigate(it) }
            )
        }

        composable<AuthDestinations.ResetPassScreen> {
            ResetPassScreen(
                onNavigateTo = { navController.navigate(it) },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable<AuthDestinations.SuccessResetScreen> {
            SuccessResetScreen(
                onNavigateTo = { navController.navigate(it) },
            )
        }
    }
}


