package com.example.planteria.extensions

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun adaptiveTextSize(base: Int): TextUnit {
    val screenInches = getScreenInches()

    val scale = when {
        screenInches < 4.8 -> 0.7f
        screenInches < 7 -> 1.0f
        else -> 1.2f
    }
    Log.i("MYLOG", "Inches = $screenInches + ${(base * scale).sp}")
    return (base * scale).sp
}


