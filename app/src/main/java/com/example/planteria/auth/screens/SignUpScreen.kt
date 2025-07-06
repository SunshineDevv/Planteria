package com.example.planteria.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.planteria.R
import com.example.planteria.extensions.adaptivePadding
import com.example.planteria.extensions.adaptiveTextSize
import com.example.planteria.ui.base.AuthTextField
import com.example.planteria.ui.base.OrDivider
import com.example.planteria.ui.base.RowIconButton
import com.example.planteria.ui.base.StandardButton
import com.example.planteria.ui.navigation.AuthDestinations
import com.example.planteria.ui.theme.GreenAccent
import com.example.planteria.ui.theme.GreenSecondary
import com.example.planteria.ui.theme.Manrope
import com.example.planteria.ui.theme.Poppins
import com.example.planteria.ui.theme.TextColor

@Composable
fun SignUpScreen(onNavigateTo: (AuthDestinations) -> Unit) {

    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenSecondary)
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .background(GreenSecondary)
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.ic_logo_app_2),
                contentDescription = "Logo",
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4.5f)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 100.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {

            Text(
                modifier = Modifier
                    .adaptivePadding(top = 56.dp, bottom = 48.dp),
                text = "Sign up",
                fontSize = adaptiveTextSize(32),
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold
            )

            AuthTextField(
                text = userName,
                onValueChange = { userName = it },
                placeHolderText = "User name",
                visualTransformation = VisualTransformation.None,
                isSingleLine = true,
                cursorColor = TextColor,
            )

            AuthTextField(
                modifier = Modifier
                    .adaptivePadding(top = 14.dp),
                text = email,
                onValueChange = { email = it },
                placeHolderText = "Email",
                visualTransformation = VisualTransformation.None,
                isSingleLine = true,
                cursorColor = TextColor,
            )

            AuthTextField(
                modifier = Modifier
                    .adaptivePadding(top = 14.dp),
                text = password,
                onValueChange = { password = it },
                placeHolderText = "Password",
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                isSingleLine = true,
                cursorColor = TextColor,
                showPasswordToggle = true,
                isPasswordVisible = passwordVisible,
                onVisibilityToggle = { passwordVisible = !passwordVisible }
            )

            AuthTextField(
                modifier = Modifier
                    .adaptivePadding(top = 14.dp),
                text = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeHolderText = "Confirm password",
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                isSingleLine = true,
                cursorColor = TextColor,
                showPasswordToggle = true,
                isPasswordVisible = confirmPasswordVisible,
                onVisibilityToggle = { confirmPasswordVisible = !confirmPasswordVisible }
            )

            StandardButton(
                modifier = Modifier
                    .adaptivePadding(
                        top = 48.dp,
                        smallScreenMultiplier = 0.3f,
                        mediumScreenMultiplier = 0.6f
                    ),
                text = "Sign up",
                iconRes = null,
                onClick = { },
                containerColor = GreenAccent,
                fontColor = Color.White
            )

            Text(
                "Already have an account",
                modifier = Modifier
                    .adaptivePadding(
                        top = 32.dp,
                        mediumScreenMultiplier = 0.7f)
                    .clickable { onNavigateTo(AuthDestinations.LogInScreen) },
                color = GreenAccent,
                textDecoration = TextDecoration.Underline,
                fontFamily = Manrope,
                fontWeight = FontWeight.Medium,
                fontSize = adaptiveTextSize(14)
            )

            OrDivider(
                modifier = Modifier
                    .adaptivePadding(
                        top = 40.dp,
                        smallScreenMultiplier = 0.2f,
                        mediumScreenMultiplier = 0.5f
                    )
            )

            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .adaptivePadding(
                        top = 32.dp,
                        smallScreenMultiplier = 0.5f,
                        mediumScreenMultiplier = 0.5f
                    ),
                horizontalArrangement = Arrangement.Center
            ) {

                RowIconButton(
                    modifier = Modifier.padding(end = 10.dp),
                    iconRes = R.drawable.ic_google_logo,
                    contentDescription = "Google"
                )

                RowIconButton(
                    iconRes = R.drawable.ic_facebook_logo,
                    contentDescription = "Facebook"
                )
            }
        }
    }
}
