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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.theme.CardShape
import com.example.proyectolaboratorio03.ui.theme.Gray500
import com.example.proyectolaboratorio03.ui.theme.UnsaGold
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Organism: Tarjeta de Método de Inscripción (Método 1 y Método 2)
 */
@Composable
fun UnsaMethodCard(
    methodNumber: String,
    title: String,
    description: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isPrimary: Boolean = true,
    icon: ImageVector = if (isPrimary) Icons.Default.DateRange else Icons.Default.GridView
) {
    val backgroundColor = if (isPrimary) UnsaGreen else White
    val borderModifier = if (isPrimary) Modifier else Modifier.border(2.dp, UnsaGreen, CardShape)
    val titleColor = if (isPrimary) White else UnsaGreen
    val descriptionColor = if (isPrimary) White.copy(alpha = 0.65f) else Gray500
    val iconBgColor = if (isPrimary) White.copy(alpha = 0.15f) else UnsaGreen.copy(alpha = 0.1f)
    val iconColor = if (isPrimary) White else UnsaGreen
    val chevronColor = if (isPrimary) White else UnsaGreen

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(CardShape)
            .then(borderModifier)
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon Container
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(iconBgColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(28.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Content
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = methodNumber.uppercase(),
                color = UnsaGold,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.2.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = title,
                color = titleColor,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = description,
                color = descriptionColor,
                fontSize = 13.sp,
                lineHeight = 17.sp
            )
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = chevronColor,
            modifier = Modifier.size(24.dp)
        )
    }
}
