package com.example.planteria.ui.base

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.planteria.extensions.adaptivePadding
import com.example.planteria.extensions.adaptiveTextSize
import com.example.planteria.ui.theme.GreenSecondary
import com.example.planteria.ui.theme.Manrope

@Composable
fun OrDivider(
    modifier: Modifier = Modifier,
    color: Color = GreenSecondary,
    textColor: Color = Color.Gray,
    thickness: Dp = 1.dp,
    padding: Dp = 10.dp
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .adaptivePadding(
                start = 16.dp,
                end = 16.dp
            )
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = thickness,
            color = color.copy(alpha = 0.7f)
        )
        Text(
            text = "or",
            modifier = Modifier.padding(horizontal = padding),
            color = textColor,
            fontSize = adaptiveTextSize(14),
            fontFamily = Manrope
        )
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = thickness,
            color = color
        )
    }
}