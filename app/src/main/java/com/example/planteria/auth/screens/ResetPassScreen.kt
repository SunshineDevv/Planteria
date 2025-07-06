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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planteria.R
import com.example.planteria.extensions.adaptivePadding
import com.example.planteria.extensions.adaptiveSize
import com.example.planteria.extensions.adaptiveTextSize
import com.example.planteria.ui.base.AuthTextField
import com.example.planteria.ui.base.StandardButton
import com.example.planteria.ui.navigation.AuthDestinations
import com.example.planteria.ui.theme.DarkGreyCustom
import com.example.planteria.ui.theme.GreenAccent
import com.example.planteria.ui.theme.GreyCustom
import com.example.planteria.ui.theme.Manrope
import com.example.planteria.ui.theme.Poppins
import com.example.planteria.ui.theme.PrimaryColor
import com.example.planteria.ui.theme.RedCustom
import com.example.planteria.ui.theme.TextColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPassScreen(onNavigateTo: (AuthDestinations) -> Unit, onNavigateBack: () -> Unit) {

    var email by remember { mutableStateOf("") }

    var isEmailValid: Boolean? = null
    var showError by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                title = { },
                navigationIcon = {
                    IconButton(onClick = {
                        onNavigateBack()
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) {

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
                    .padding(paddingValues = it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    modifier = Modifier
                        .adaptivePadding(top = 16.dp),
                    text = "Reset Password",
                    fontSize = adaptiveTextSize(32),
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    color = TextColor
                )

                Text(
                    modifier = Modifier
                        .adaptivePadding(top = 16.dp),
                    text = "We’ll send you a link to the email address\n you signed up with.",
                    fontSize = adaptiveTextSize(14),
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = TextColor.copy(alpha = 0.8f),
                    lineHeight = 20.sp
                )

                AuthTextField(
                    modifier = Modifier
                        .adaptivePadding(top = 52.dp),
                    text = email,
                    onValueChange = {
                        email = it
                        if (it.isNotBlank()) {
                            isEmailValid = true
                            showError = false
                        } else {
                            isEmailValid = false
                        }
                    },
                    backgroundColor = if (!showError) PrimaryColor else RedCustom.copy(alpha = 0.1f),
                    borderStrokeColor = if (!showError) PrimaryColor else RedCustom,
                    placeHolderText = "Email",
                    visualTransformation = VisualTransformation.None,
                    isSingleLine = true,
                    cursorColor = TextColor,
                )

                if (showError) {
                    Text(
                        modifier = Modifier
                            .adaptivePadding(top = 8.dp)
                            .adaptiveSize(),
                        text = "We can’t find this email address in our records. Please, try again.",
                        fontSize = adaptiveTextSize(14),
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start,
                        color = RedCustom,
                        lineHeight = 20.sp
                    )
                }

                StandardButton(
                    modifier = Modifier
                        .adaptivePadding(top = 16.dp),
                    text = "Send reset link",
                    iconRes = null,
                    containerColor = if (!showError) GreenAccent else GreyCustom,
                    borderStrokeColor = if (!showError) GreenAccent else GreyCustom,
                    fontColor = if (!showError) Color.White else DarkGreyCustom.copy(
                        alpha = 0.5f
                    ),
                    onClick = {
                        if (isEmailValid == true) {
                            showError = false
                            onNavigateTo(AuthDestinations.SuccessResetScreen)
                        } else {
                            showError = true
                        }
                    },
                    isEnable = !showError
                )

                Row(
                    modifier = Modifier
                        .adaptivePadding(
                            top = 14.dp,
                            smallScreenMultiplier = 0.4f,
                            mediumScreenMultiplier = 0.85f
                        )
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        modifier = Modifier.padding(end = 4.dp),
                        text = "Remember password?",
                        color = GreenAccent,
                        fontFamily = Manrope,
                        fontWeight = FontWeight.Medium,
                        fontSize = adaptiveTextSize(14)
                    )

                    Text(
                        modifier = Modifier.clickable {
                            onNavigateTo(AuthDestinations.LogInScreen)
                        },
                        text = "Log in",
                        color = GreenAccent,
                        textDecoration = TextDecoration.Underline,
                        fontFamily = Manrope,
                        fontWeight = FontWeight.Bold,
                        fontSize = adaptiveTextSize(14)
                    )
                }
            }
        }
    }
}