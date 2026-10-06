package com.example.proyectolaboratorio03.ui.designsystem.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaStatusBadge
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Organism: Cabecera del Dashboard del estudiante con saludo y periodo académico
 * Respeta la barra de notificaciones del sistema con statusBarsPadding().
 */
@Composable
fun UnsaDashboardHeader(
    studentName: String = "Carlos Mamani",
    semester: String = "Semestre 2026-I",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(UnsaGreen)
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Text(
            text = "Bienvenido,",
            color = White.copy(alpha = 0.7f),
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = studentName,
            color = White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        UnsaStatusBadge(text = semester)
    }
}
