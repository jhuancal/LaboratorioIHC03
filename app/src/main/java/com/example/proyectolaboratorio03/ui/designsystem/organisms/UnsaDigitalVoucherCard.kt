package com.example.proyectolaboratorio03.ui.designsystem.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaQrCode
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaStatusBadge
import com.example.proyectolaboratorio03.ui.theme.CardShape
import com.example.proyectolaboratorio03.ui.theme.Gray400
import com.example.proyectolaboratorio03.ui.theme.Gray500
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Organism: Tarjeta de Comprobante Digital Oficial con Código QR
 */
@Composable
fun UnsaDigitalVoucherCard(
    workshopName: String = "Fútsal · Grupo 02",
    studentInfo: String = "Carlos Mamani · 20210001",
    scheduleInfo: String = "Mié 16:00 – 18:00 · Prof. Quispe",
    validityBadge: String = "UNSA 2026-I · VÁLIDO",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(CardShape)
            .background(White)
            .border(2.dp, UnsaGreen.copy(alpha = 0.2f), CardShape)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Card Title with dots
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(UnsaGreen)
            )
            Text(
                text = "COMPROBANTE DIGITAL",
                color = UnsaGreen,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.2.sp
            )
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(UnsaGreen)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // QR Code
        UnsaQrCode(size = 160.dp)

        Spacer(modifier = Modifier.height(16.dp))

        // Student & Class Info
        Text(
            text = workshopName,
            color = UnsaGreen,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = studentInfo,
            color = Gray500,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = scheduleInfo,
            color = Gray400,
            fontSize = 11.sp
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Validity Pill
        UnsaStatusBadge(text = validityBadge)
    }
}
