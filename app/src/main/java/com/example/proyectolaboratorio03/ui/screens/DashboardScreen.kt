package com.example.proyectolaboratorio03.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyectolaboratorio03.model.MockData
import com.example.proyectolaboratorio03.model.Student
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaSectionTitle
import com.example.proyectolaboratorio03.ui.designsystem.molecules.UnsaStatCard
import com.example.proyectolaboratorio03.ui.designsystem.organisms.UnsaDashboardHeader
import com.example.proyectolaboratorio03.ui.designsystem.organisms.UnsaMethodCard
import com.example.proyectolaboratorio03.ui.theme.UnsaGold
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenSurface

/**
 * Pantalla 2: Dashboard del Estudiante
 * Alimentada por la clase Student y MockData sin requerir backend.
 */
@Composable
fun DashboardScreen(
    onMethod1Click: () -> Unit,
    onMethod2Click: () -> Unit,
    student: Student = MockData.currentStudent,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(UnsaGreenSurface)
    ) {
        // Cabecera institucional alimentada con la data de la clase Student
        UnsaDashboardHeader(
            studentName = student.fullName,
            semester = student.semester
        )

        // Contenido con Scroll
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
                .padding(20.dp)
        ) {
            // Métricas pobladas desde la clase Student
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                UnsaStatCard(
                    title = "Inscritos",
                    value = "${student.enrolledWorkshopsCount}",
                    subtitle = "talleres",
                    valueColor = UnsaGreen,
                    modifier = Modifier.weight(1f)
                )
                UnsaStatCard(
                    title = "Cupos disp.",
                    value = "${student.availableSlotsCount}",
                    subtitle = "disponibles",
                    valueColor = UnsaGold,
                    modifier = Modifier.weight(1f)
                )
                UnsaStatCard(
                    title = "Créditos",
                    value = "${student.accumulatedCredits}",
                    subtitle = "acumulados",
                    valueColor = UnsaGreen,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            UnsaSectionTitle(text = "Inscripciones")

            UnsaMethodCard(
                methodNumber = "Método 1",
                title = "Filtrar por horarios libres",
                description = "Encuentra talleres que encajan con tu horario",
                isPrimary = true,
                onClick = onMethod1Click
            )

            Spacer(modifier = Modifier.height(14.dp))

            UnsaMethodCard(
                methodNumber = "Método 2",
                title = "Catálogo completo",
                description = "Explora todos los talleres disponibles",
                isPrimary = false,
                onClick = onMethod2Click
            )
        }
    }
}
