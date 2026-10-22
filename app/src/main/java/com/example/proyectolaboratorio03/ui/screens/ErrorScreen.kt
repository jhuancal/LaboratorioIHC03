package com.example.proyectolaboratorio03.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaSecondaryButton
import com.example.proyectolaboratorio03.ui.designsystem.molecules.UnsaInfoBanner
import com.example.proyectolaboratorio03.ui.designsystem.molecules.UnsaSyncStatusCard
import com.example.proyectolaboratorio03.ui.theme.Gray800
import com.example.proyectolaboratorio03.ui.theme.ProyectoLaboratorio03Theme
import com.example.proyectolaboratorio03.ui.theme.UnsaRed
import com.example.proyectolaboratorio03.ui.theme.UnsaRedLight
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Pantalla 8: Error de Conexión y Respaldo Offline
 * Ensamblada con Atomic Design:
 * - Molecules: UnsaInfoBanner, UnsaSyncStatusCard
 * - Atoms: UnsaSecondaryButton
 */
@Composable
fun ErrorScreen(
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        // Contenido central de error
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .background(UnsaRedLight),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.WifiOff,
                    contentDescription = null,
                    tint = UnsaRed,
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "❌ Error de conexión",
                color = UnsaRed,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Sin conexión a internet",
                color = Gray800,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            UnsaInfoBanner(
                message = "Tu solicitud ha sido guardada localmente. Se sincronizará automáticamente cuando recuperes la señal."
            )

            Spacer(modifier = Modifier.height(16.dp))

            UnsaSyncStatusCard(
                title = "Guardado localmente",
                subtitle = "Fútsal · Grupo 02 · pendiente de envío"
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            UnsaSecondaryButton(
                text = "REINTENTAR ENVÍO",
                onClick = onRetryClick
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
private fun ErrorScreenPreview() {
    ProyectoLaboratorio03Theme {
        ErrorScreen(
            onRetryClick = {}
        )
    }
}
