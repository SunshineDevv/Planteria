package com.example.planteria.auth.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planteria.R
import com.example.planteria.ui.base.StandardButton
import com.example.planteria.ui.theme.RedCustom
import kotlinx.coroutines.delay


@Preview(showSystemUi = true)
@Composable
fun ErrorBannerScreenPreview() {
    ErrorBannerScreen()
}

@Composable
fun ErrorBannerScreen() {
    var showBanner by remember { mutableStateOf(true) }
    var progress by remember { mutableStateOf(1f) }

    LaunchedEffect(showBanner) {
        if (showBanner) {
            val duration = 3000L
            val stepTime = 10L
            val steps = (duration / stepTime).toInt()

            repeat(steps) { i ->
                delay(stepTime)
                progress = 1f - i / steps.toFloat()
            }

            showBanner = false
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE5F4FF))
                .statusBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            StandardButton(
                modifier = Modifier.safeContentPadding(),
                onClick = {
                    showBanner = true
                    progress = 1f
                },
                iconRes = null,
                text = "Trigger error"
            )
        }

        // Баннер
        AnimatedVisibility(
            visible = showBanner,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 20.dp)
                .statusBarsPadding()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color(0xFFFFE0E0))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Please fill all required fields",
                        color = RedCustom,
                        modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.Medium
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "Close",
                        modifier = Modifier
                            .clickable { showBanner = false }
                            .padding(start = 8.dp)
                            .size(24.dp),
                        tint = RedCustom
                    )
                }

                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp),
                    strokeCap = StrokeCap.Round,
                    color = RedCustom,
                    trackColor = Color(0xFFFFF0F0),
                    drawStopIndicator = {}
                )
            }
        }
    }
}


