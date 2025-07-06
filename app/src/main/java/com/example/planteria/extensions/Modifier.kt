package com.example.planteria.extensions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Modifier.adaptiveSize(
    smallFraction: Float = 0.85f,
    mediumFraction: Float = 0.75f,
    largeFraction: Float = 0.8f
): Modifier {
    val screenInches = getScreenInches()

    val fraction = when {
        screenInches < 5.5 -> smallFraction
        screenInches < 7 -> mediumFraction
        else -> largeFraction
    }

    return this.fillMaxWidth(fraction)
}


@Composable
fun Modifier.adaptivePadding(
    start: Dp = 0.dp,
    top: Dp = 0.dp,
    end: Dp = 0.dp,
    bottom: Dp = 0.dp,
    smallScreenMultiplier: Float = 0.65f,
    mediumScreenMultiplier: Float = 1f,
    largeScreenMultiplier: Float = 1.25f
): Modifier {
    val screenInches = getScreenInches()

    val scale = when {
        screenInches < 4.8 -> smallScreenMultiplier
        screenInches < 7 -> mediumScreenMultiplier
        else -> largeScreenMultiplier
    }

    return this.padding(
        start = start * scale,
        top = top * scale,
        end = end * scale,
        bottom = bottom * scale
    )
}

@Composable
fun Modifier.adaptiveWHS(
    baseSize: Dp,
    type: SizeType
): Modifier {
    val screenInches = getScreenInches()

    val scale = when {
        screenInches < 4.8 -> 0.8f
        screenInches < 7 -> 1.0f
        else -> 1.2f
    }

    val scaledSize = baseSize * scale

    return when (type) {
        SizeType.Height -> this.height(scaledSize)
        SizeType.Width -> this.width(scaledSize)
        SizeType.Size -> this.size(scaledSize)
    }
}

enum class SizeType {
    Height, Width, Size
}
