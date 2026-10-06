package com.example.proyectolaboratorio03.ui.designsystem.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.theme.Gray200
import com.example.proyectolaboratorio03.ui.theme.Gray400
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Molecule: Indicador de paso en el proceso de inscripción
 */
@Composable
fun UnsaProgressStepItem(
    label: String,
    isDone: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(22.dp)
                .clip(CircleShape)
                .background(if (isDone) UnsaGreen else Gray200),
            contentAlignment = Alignment.Center
        ) {
            if (isDone) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.size(14.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = label,
            color = if (isDone) UnsaGreen else Gray400,
            fontSize = 14.sp,
            fontWeight = if (isDone) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}
