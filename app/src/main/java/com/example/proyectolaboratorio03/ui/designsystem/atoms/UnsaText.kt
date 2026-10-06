package com.example.proyectolaboratorio03.ui.designsystem.atoms

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.theme.Gray500
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Atom: Título de Sección con mayúsculas y tracking espaciado
 */
@Composable
fun UnsaSectionTitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = UnsaGreen
) {
    Text(
        text = text,
        color = color,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 1.2.sp,
        modifier = modifier.padding(bottom = 12.dp)
    )
}

/**
 * Atom: Título principal de pantalla
 */
@Composable
fun UnsaScreenTitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White
) {
    Text(
        text = text,
        color = color,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.3).sp,
        modifier = modifier
    )
}

/**
 * Atom: Subtítulo de cabecera o detalle
 */
@Composable
fun UnsaSubtitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White.copy(alpha = 0.7f)
) {
    Text(
        text = text,
        color = color,
        fontSize = 13.sp,
        fontWeight = FontWeight.Normal,
        modifier = modifier
    )
}
