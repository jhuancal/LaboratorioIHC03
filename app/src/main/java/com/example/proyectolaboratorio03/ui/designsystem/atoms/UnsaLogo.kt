package com.example.proyectolaboratorio03.ui.designsystem.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.theme.UnsaGold
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenDark
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Atom: Emblema Circular Oficial UNSA (Pantalla de Login y Branding)
 */
@Composable
fun UnsaEmblemLogo(
    modifier: Modifier = Modifier,
    size: Dp = 96.dp
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(White.copy(alpha = 0.15f))
            .border(3.dp, White.copy(alpha = 0.4f), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(size * 0.75f)
                .border(2.dp, White, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "UNSA",
                color = White,
                fontSize = (size.value * 0.18f).sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
        }
    }
}

/**
 * Atom: Logotipo compacto en miniatura para encabezados
 */
@Composable
fun UnsaSquareMiniLogo(
    modifier: Modifier = Modifier,
    size: Dp = 32.dp
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(8.dp))
            .background(UnsaGold),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "U",
            color = UnsaGreenDark,
            fontSize = 14.sp,
            fontWeight = FontWeight.Black
        )
    }
}
