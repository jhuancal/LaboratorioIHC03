package com.example.proyectolaboratorio03.ui.designsystem.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.theme.CardShape
import com.example.proyectolaboratorio03.ui.theme.UnsaAmberBg
import com.example.proyectolaboratorio03.ui.theme.UnsaAmberBorder
import com.example.proyectolaboratorio03.ui.theme.UnsaAmberText

/**
 * Molecule: Banner informativo o de advertencia (Notificación offline guardada)
 */
@Composable
fun UnsaInfoBanner(
    message: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(CardShape)
            .background(UnsaAmberBg)
            .border(1.dp, UnsaAmberBorder, CardShape)
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Text(
            text = message,
            color = UnsaAmberText,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Normal
        )
    }
}
