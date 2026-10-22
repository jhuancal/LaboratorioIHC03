package com.example.proyectolaboratorio03.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectolaboratorio03.model.MockData
import com.example.proyectolaboratorio03.model.WorkshopGroup
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaPrimaryButton
import com.example.proyectolaboratorio03.ui.designsystem.organisms.UnsaGroupCard
import com.example.proyectolaboratorio03.ui.designsystem.organisms.UnsaHeader
import com.example.proyectolaboratorio03.ui.theme.ProyectoLaboratorio03Theme
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenSurface

/**
 * Pantalla 6: Selección de Grupo y Horario
 * Alimentada por la clase WorkshopGroup y MockData.
 */
@Composable
fun GroupScreen(
    workshopName: String = "Fútsal",
    onBackClick: () -> Unit,
    onConfirmEnrollment: (WorkshopGroup) -> Unit,
    groups: List<WorkshopGroup> = MockData.futsalGroups,
    modifier: Modifier = Modifier
) {
    var selectedGroupId by remember { mutableStateOf<Int?>(2) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(UnsaGreenSurface)
    ) {
        UnsaHeader(
            title = workshopName,
            subtitle = "Selecciona un grupo",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            groups.forEach { group ->
                UnsaGroupCard(
                    groupName = group.name,
                    instructor = group.instructor,
                    schedule = group.schedule,
                    cupos = group.availableSlots,
                    isSelected = selectedGroupId == group.id,
                    isFull = group.isFull,
                    isCritical = group.isCritical,
                    onClick = {
                        if (!group.isFull) {
                            selectedGroupId = group.id
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            val selectedGroup = groups.find { it.id == selectedGroupId } ?: groups.firstOrNull()
            UnsaPrimaryButton(
                text = "CONFIRMAR INSCRIPCIÓN",
                enabled = true,
                onClick = {
                    selectedGroup?.let { onConfirmEnrollment(it) }
                }
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
private fun GroupScreenPreview() {
    ProyectoLaboratorio03Theme {
        GroupScreen(
            onBackClick = {},
            onConfirmEnrollment = {}
        )
    }
}
