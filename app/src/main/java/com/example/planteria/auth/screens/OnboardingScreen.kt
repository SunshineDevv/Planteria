package com.example.planteria.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.planteria.R
import com.example.planteria.extensions.adaptivePadding
import com.example.planteria.extensions.adaptiveTextSize
import com.example.planteria.ui.base.StandardButton
import com.example.planteria.ui.navigation.AuthDestinations
import com.example.planteria.ui.theme.GreenAccent
import com.example.planteria.ui.theme.Manrope

@Composable
fun OnboardingScreen(onNavigateTo: (AuthDestinations) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .adaptivePadding(top = 30.dp),
            painter = painterResource(id = R.drawable.ic_logo_app_1),
            contentDescription = "Logo",
        )

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            painter = painterResource(id = R.drawable.img_onboarding),
            contentDescription = "Logo"
        )

        StandardButton(
            text = "Sign up free",
            iconRes = null,
            onClick = { onNavigateTo(AuthDestinations.SignUpScreen) },
            containerColor = GreenAccent,
            fontColor = Color.White
        )

        StandardButton(
            text = "Continue with Google",
            iconRes = R.drawable.ic_google_logo,
            onClick = {})

        StandardButton(
            text = "Continue with Facebook",
            iconRes = R.drawable.ic_facebook_logo,
            onClick = {})

        Text(
            "Already have an account",
            modifier = Modifier
                .adaptivePadding(top = 14.dp)
                .clickable {
                    onNavigateTo(AuthDestinations.LogInScreen)
                },
            color = GreenAccent,
            textDecoration = TextDecoration.Underline,
            fontFamily = Manrope,
            fontWeight = FontWeight.Medium,
            fontSize = adaptiveTextSize(14)
        )
    }
}

