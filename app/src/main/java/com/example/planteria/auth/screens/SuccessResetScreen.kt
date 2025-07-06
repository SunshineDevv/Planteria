package com.example.planteria.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planteria.R
import com.example.planteria.extensions.adaptivePadding
import com.example.planteria.extensions.adaptiveTextSize
import com.example.planteria.ui.base.StandardButton
import com.example.planteria.ui.navigation.AuthDestinations
import com.example.planteria.ui.theme.GreenAccent
import com.example.planteria.ui.theme.Poppins
import com.example.planteria.ui.theme.TextColor

@Composable
fun SuccessResetScreen(onNavigateTo: (AuthDestinations) -> Unit) {

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_background_plant),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillWidth
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .adaptivePadding(top = 30.dp),
                painter = painterResource(id = R.drawable.ic_logo_app_2),
                contentDescription = "Logo",
            )

            Text(
                modifier = Modifier.adaptivePadding(top = 112.dp),
                text = "Update link is sent!",
                fontSize = adaptiveTextSize(32),
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                color = TextColor
            )

            Text(
                modifier = Modifier
                    .adaptivePadding(top = 16.dp)
                    .padding(horizontal = 20.dp),
                text = "Check your email and follow the instructions.",
                fontSize = adaptiveTextSize(14),
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                color = TextColor.copy(alpha = 0.8f),
                lineHeight = 20.sp
            )

            StandardButton(
                modifier = Modifier.adaptivePadding(top = 16.dp),
                text = "Back to Planteria",
                iconRes = null,
                onClick = { onNavigateTo(AuthDestinations.OnboardingScreen) },
                containerColor = GreenAccent,
                fontColor = Color.White
            )
        }
    }
}