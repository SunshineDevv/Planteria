package com.example.planteria.ui.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.planteria.extensions.SizeType
import com.example.planteria.extensions.adaptivePadding
import com.example.planteria.extensions.adaptiveSize
import com.example.planteria.extensions.adaptiveTextSize
import com.example.planteria.extensions.adaptiveWHS
import com.example.planteria.ui.theme.GreenAccent
import com.example.planteria.ui.theme.GreyCustom
import com.example.planteria.ui.theme.Poppins
import com.example.planteria.ui.theme.PrimaryColor

@Composable
fun RowIconButton(
    modifier: Modifier = Modifier,
    buttonWidth: Dp = 60.dp,
    buttonHeight: Dp = 44.dp,
    backgroundColor: Color = PrimaryColor,
    cornerRadius: Dp = 16.dp,
    iconRes: Int,
    iconSize: Dp = 24.dp,
    contentDescription: String,
    onAction: () -> Unit = {}
) {
    IconButton(
        modifier = modifier
            .adaptiveWHS(buttonWidth, SizeType.Width)
            .adaptiveWHS(buttonHeight, SizeType.Height)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(cornerRadius)
            ),
        onClick = { onAction() },
    ) {
        Icon(
            modifier = Modifier.adaptiveWHS(iconSize, SizeType.Size),
            painter = painterResource(iconRes),
            contentDescription = contentDescription,
            tint = Color.Unspecified
        )
    }
}

@Composable
fun StandardButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconRes: Int?,
    iconSize: Dp = 24.dp,
    buttonHeight: Dp = 48.dp,
    containerColor: Color = Color.White,
    borderStrokeColor: Color = GreenAccent,
    text: String,
    fontSize: Int = 16,
    fontColor: Color = Color.Black,
    isEnable: Boolean = true

) {
    Button(
        onClick = onClick,
        modifier = modifier
            .adaptiveSize()
            .adaptivePadding(top = 14.dp)
            .adaptiveWHS(buttonHeight, SizeType.Height),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            disabledContainerColor = GreyCustom
        ),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, color = borderStrokeColor),
        contentPadding = PaddingValues(horizontal = 10.dp),
        enabled = isEnable
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = fontColor,
                fontSize = adaptiveTextSize(fontSize),
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold
            )
            iconRes?.let { painterResource(id = it) }?.let {
                Image(
                    painter = it,
                    contentDescription = text,
                    modifier = Modifier
                        .padding(8.dp)
                        .adaptiveWHS(iconSize, SizeType.Size)
                        .align(Alignment.CenterStart)
                )
            }
        }
    }
}