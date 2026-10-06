package com.example.proyectolaboratorio03.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import com.example.proyectolaboratorio03.model.MockData
import com.example.proyectolaboratorio03.model.TimeFilter
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaSecondaryButton
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaSectionTitle
import com.example.proyectolaboratorio03.ui.designsystem.molecules.UnsaDaySelectorRow
import com.example.proyectolaboratorio03.ui.designsystem.molecules.UnsaFilterSummaryChip
import com.example.proyectolaboratorio03.ui.designsystem.molecules.UnsaToggleSettingRow
import com.example.proyectolaboratorio03.ui.designsystem.molecules.UnsaTurnSelectorRow
import com.example.proyectolaboratorio03.ui.designsystem.organisms.UnsaHeader
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenSurface

/**
 * Pantalla 4: Filtro de Horarios Disponibles
 * Gestiona el estado a través de la clase TimeFilter y MockData.
 */
@Composable
fun TimeFilterScreen(
    onBackClick: () -> Unit,
    onApplyFilter: (TimeFilter) -> Unit,
    initialFilter: TimeFilter = MockData.defaultTimeFilter,
    modifier: Modifier = Modifier
) {
    var selectedDays by remember { mutableStateOf(initialFilter.selectedDays) }
    var selectedTurn by remember { mutableStateOf(initialFilter.selectedTurn) }
    var soloLibres by remember { mutableStateOf(initialFilter.onlyFreeBlocks) }

    val currentFilter = TimeFilter(
        selectedDays = selectedDays,
        selectedTurn = selectedTurn,
        onlyFreeBlocks = soloLibres
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(UnsaGreenSurface)
    ) {
        UnsaHeader(
            title = "Filtro de Horarios",
            subtitle = "Personaliza tu búsqueda",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
                .padding(20.dp)
        ) {
            // Sección 1: Días
            UnsaSectionTitle(text = "Días disponibles")
            UnsaDaySelectorRow(
                days = MockData.availableDays,
                selectedDays = selectedDays,
                onDayToggled = { day ->
                    selectedDays = if (selectedDays.contains(day)) {
                        selectedDays - day
                    } else {
                        selectedDays + day
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Sección 2: Turno
            UnsaSectionTitle(text = "Turno preferido")
            UnsaTurnSelectorRow(
                turns = MockData.availableTurns,
                selectedTurn = selectedTurn,
                onTurnSelected = { selectedTurn = it }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Sección 3: Toggle
            UnsaToggleSettingRow(
                title = "Solo bloques libres",
                description = "Excluye conflictos con tu horario actual",
                checked = soloLibres,
                onCheckedChange = { soloLibres = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Resumen dinámico generado desde la clase TimeFilter
            if (currentFilter.summaryText.isNotEmpty()) {
                UnsaFilterSummaryChip(summaryText = currentFilter.summaryText)
            }

            Spacer(modifier = Modifier.height(28.dp))

            UnsaSecondaryButton(
                text = "APLICAR FILTRO",
                onClick = { onApplyFilter(currentFilter) }
            )
        }
    }
}
