package com.example.proyectolaboratorio03.ui.designsystem.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.theme.Gray200
import com.example.proyectolaboratorio03.ui.theme.Gray500
import com.example.proyectolaboratorio03.ui.theme.UnsaGold
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenContainer
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenDark
import com.example.proyectolaboratorio03.ui.theme.UnsaRed
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Atom: Badge de Estado o Semestre (Pill Dorada con texto verde)
 */
@Composable
fun UnsaStatusBadge(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(UnsaGold)
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = text.uppercase(),
            color = UnsaGreenDark,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.8.sp
        )
    }
}

/**
 * Atom: Tag o Categoría suave ("Deportes", "Tecnología")
 */
@Composable
fun UnsaTagBadge(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = UnsaGreenContainer,
    textColor: Color = UnsaGreen
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/**
 * Atom: Badge de Cupos / Cantidad (4 cupos, LLENO, 4 talleres)
 */
@Composable
fun UnsaCounterBadge(
    count: Int,
    isFull: Boolean = false,
    isCritical: Boolean = false,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier
) {
    val (bgColor, textColor, label) = when {
        isFull -> Triple(Gray200, Gray500, "LLENO")
        isCritical -> Triple(UnsaRed, White, "$count cupos")
        isSelected -> Triple(White.copy(alpha = 0.2f), White, "$count cupos")
        else -> Triple(UnsaGreenContainer, UnsaGreen, "$count cupos")
    }

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(bgColor)
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(
            text = label,
            color = textColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/**
 * Atom: Badge de Alerta Roja para Cupos Críticos
 */
@Composable
fun UnsaCriticalAlertBadge(
    message: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(UnsaRed)
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Text(
            text = message,
            color = White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
