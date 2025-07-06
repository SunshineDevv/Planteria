package com.example.planteria.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.planteria.R
import com.example.planteria.extensions.SizeType
import com.example.planteria.extensions.adaptiveSize
import com.example.planteria.extensions.adaptiveTextSize
import com.example.planteria.extensions.adaptiveWHS
import com.example.planteria.ui.theme.GreenAccent
import com.example.planteria.ui.theme.Poppins
import com.example.planteria.ui.theme.PrimaryColor
import com.example.planteria.ui.theme.TextColor

@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    isSingleLine: Boolean = true,
    placeHolderText: String,
    cursorColor: Color,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    showPasswordToggle: Boolean = false,
    isPasswordVisible: Boolean = false,
    onVisibilityToggle: (() -> Unit)? = null,
    backgroundColor: Color = PrimaryColor,
    borderStrokeColor: Color = PrimaryColor
) {
    BasicTextField(
        modifier = modifier
            .adaptiveSize()
            .adaptiveWHS(48.dp, SizeType.Height)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = borderStrokeColor,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 20.dp),
        value = text,
        onValueChange = { onValueChange(it) },
        singleLine = isSingleLine,
        cursorBrush = SolidColor(cursorColor),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(end = if (showPasswordToggle) 8.dp else 0.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (text.isEmpty()) {
                        Text(
                            modifier = Modifier.align(Alignment.CenterStart),
                            text = placeHolderText,
                            color = TextColor.copy(alpha = 0.5f),
                            fontFamily = Poppins,
                            fontSize = adaptiveTextSize(16)
                        )
                    }
                    innerTextField()
                }
                if (showPasswordToggle && onVisibilityToggle != null) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .clickable { onVisibilityToggle() },
                        contentAlignment = Alignment.Center
                    ) {
                        val iconRes = if (isPasswordVisible) {
                            R.drawable.ic_pass_invisible
                        } else {
                            R.drawable.ic_pass_visible
                        }
                        Icon(
                            painter = painterResource(id = iconRes),
                            contentDescription = "Toggle password visibility",
                            tint = GreenAccent
                        )
                    }
                }
            }
        },
        textStyle = LocalTextStyle.current.copy(
            color = Color.Black,
            fontFamily = Poppins,
            fontSize = adaptiveTextSize(16)
        ),
        visualTransformation = visualTransformation
    )
}