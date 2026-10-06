package com.example.proyectolaboratorio03.ui.designsystem.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaCounterBadge
import com.example.proyectolaboratorio03.ui.theme.CardShape
import com.example.proyectolaboratorio03.ui.theme.Gray200
import com.example.proyectolaboratorio03.ui.theme.Gray400
import com.example.proyectolaboratorio03.ui.theme.Gray50
import com.example.proyectolaboratorio03.ui.theme.Gray500
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.UnsaRed
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Organism: Tarjeta de Selección de Grupo y Horario
 */
@Composable
fun UnsaGroupCard(
    groupName: String,
    instructor: String,
    schedule: String,
    cupos: Int,
    isSelected: Boolean,
    isFull: Boolean,
    isCritical: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val (bgColor, borderColor) = when {
        isSelected -> Pair(UnsaGreen, UnsaGreen)
        isFull -> Pair(Gray50, Gray200)
        else -> Pair(White, UnsaGreen.copy(alpha = 0.2f))
    }

    val titleColor = when {
        isSelected -> White
        isFull -> Gray400
        else -> UnsaGreen
    }

    val subtitleColor = when {
        isSelected -> White.copy(alpha = 0.7f)
        isFull -> Gray400
        else -> Gray500
    }

    val alpha = if (isFull) 0.6f else 1f

    Column(
        modifier = modifier
            .fillMaxWidth()
            .alpha(alpha)
            .clip(CardShape)
            .background(bgColor)
            .border(2.dp, borderColor, CardShape)
            .clickable(enabled = !isFull, onClick = onClick)
    ) {
        // Red alert banner if critical
        if (isCritical) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(UnsaRed)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "⚠️ ALERTA: CUPOS CRÍTICOS",
                    color = White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        text = groupName,
                        color = titleColor,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = instructor,
                        color = subtitleColor,
                        fontSize = 13.sp
                    )
                }

                UnsaCounterBadge(
                    count = cupos,
                    isFull = isFull,
                    isCritical = isCritical && !isSelected,
                    isSelected = isSelected
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Schedule,
                    contentDescription = null,
                    tint = subtitleColor,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = schedule,
                    color = subtitleColor,
                    fontSize = 13.sp
                )
            }
        }
    }
}
