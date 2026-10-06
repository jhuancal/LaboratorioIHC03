package com.example.proyectolaboratorio03.ui.designsystem.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.theme.CardShape
import com.example.proyectolaboratorio03.ui.theme.Gray400
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Molecule: Tarjeta de Métrica Rápida (Inscritos, Cupos disponibles, Créditos)
 */
@Composable
fun UnsaStatCard(
    title: String,
    value: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    valueColor: Color = UnsaGreen
) {
    Column(
        modifier = modifier
            .clip(CardShape)
            .background(White)
            .border(1.dp, UnsaGreen.copy(alpha = 0.1f), CardShape)
            .padding(14.dp)
    ) {
        Text(
            text = title.uppercase(),
            color = UnsaGreen.copy(alpha = 0.6f),
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.8.sp
        )
        Text(
            text = value,
            color = valueColor,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 2.dp)
        )
        Text(
            text = subtitle,
            color = Gray400,
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal
        )
    }
}
