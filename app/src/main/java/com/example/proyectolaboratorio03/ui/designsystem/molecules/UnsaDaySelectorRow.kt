package com.example.proyectolaboratorio03.ui.designsystem.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaDayChip

/**
 * Molecule: Selector de Días Disponibles
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UnsaDaySelectorRow(
    days: List<String>,
    selectedDays: Set<String>,
    onDayToggled: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        days.forEach { day ->
            val isSelected = selectedDays.contains(day)
            UnsaDayChip(
                day = day,
                isSelected = isSelected,
                onClick = { onDayToggled(day) }
            )
        }
    }
}
