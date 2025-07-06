package com.example.planteria.extensions

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlin.math.sqrt


@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun getScreenInches(): Float {
    val config = LocalConfiguration.current
    val density = LocalDensity.current

    val widthPx = with(density) { config.screenWidthDp.dp.toPx() }
    val heightPx = with(density) { config.screenHeightDp.dp.toPx() }

    val dpi = density.density * 160f

    val widthInches = widthPx / dpi
    val heightInches = heightPx / dpi

    return sqrt(widthInches * widthInches + heightInches * heightInches)
}