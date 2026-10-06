package com.example.proyectolaboratorio03.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyectolaboratorio03.model.MockData
import com.example.proyectolaboratorio03.model.Workshop
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaStatusBadge
import com.example.proyectolaboratorio03.ui.designsystem.organisms.UnsaHeader
import com.example.proyectolaboratorio03.ui.designsystem.organisms.UnsaWorkshopCard
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenSurface

/**
 * Pantalla 5: Resultados de Búsqueda de Talleres
 * Alimentada por la clase Workshop y MockData.
 */
@Composable
fun ResultsScreen(
    onBackClick: () -> Unit,
    onWorkshopSelected: (Workshop) -> Unit,
    workshops: List<Workshop> = MockData.workshops,
    filterSubtitle: String = "Mié · Tarde · Solo libres",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(UnsaGreenSurface)
    ) {
        UnsaHeader(
            title = "Resultados",
            subtitle = filterSubtitle,
            onBackClick = onBackClick,
            trailingContent = {
                UnsaStatusBadge(text = "${workshops.size} talleres")
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            workshops.forEach { workshop ->
                UnsaWorkshopCard(
                    name = workshop.name,
                    tag = workshop.category,
                    iconEmoji = workshop.iconEmoji,
                    day = workshop.daySummary,
                    time = workshop.timeSummary,
                    cupos = workshop.availableSlots,
                    isUrgent = workshop.isUrgent,
                    actionButtonText = if (workshop.hasAction) "VER GRUPOS" else null,
                    onClick = {
                        onWorkshopSelected(workshop)
                    }
                )
            }
        }
    }
}
