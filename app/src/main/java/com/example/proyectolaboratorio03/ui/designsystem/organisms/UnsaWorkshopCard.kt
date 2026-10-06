package com.example.proyectolaboratorio03.ui.designsystem.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaTagBadge
import com.example.proyectolaboratorio03.ui.theme.CardShape
import com.example.proyectolaboratorio03.ui.theme.Gray500
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenContainer
import com.example.proyectolaboratorio03.ui.theme.UnsaRed
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Organism: Tarjeta de Resultado de Taller con alerta de cupos críticos y acción
 */
@Composable
fun UnsaWorkshopCard(
    name: String,
    tag: String,
    iconEmoji: String,
    day: String,
    time: String,
    cupos: Int,
    isUrgent: Boolean,
    actionButtonText: String? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(CardShape)
            .background(White)
            .border(1.dp, UnsaGreen.copy(alpha = 0.1f), CardShape)
            .clickable(onClick = onClick)
    ) {
        // Banner crítico si aplica
        if (isUrgent) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(UnsaRed)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "⚠️ CUPOS CRÍTICOS — solo $cupos disponibles",
                    color = White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(UnsaGreenContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = iconEmoji,
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            // Info
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = name,
                        color = UnsaGreen,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    UnsaTagBadge(text = tag)
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "$day · $time",
                    color = Gray500,
                    fontSize = 13.sp
                )
            }

            // Optional Action Button
            if (actionButtonText != null) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(UnsaGreen)
                        .padding(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = actionButtonText.uppercase(),
                        color = White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.8.sp
                    )
                }
            }
        }
    }
}
