package com.example.proyectolaboratorio03.ui.designsystem.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaTurnChip

/**
 * Molecule: Selector de Turno Preferido (Mañana, Tarde, Noche)
 */
@Composable
fun UnsaTurnSelectorRow(
    turns: List<String>,
    selectedTurn: String,
    onTurnSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        turns.forEach { turn ->
            val isSelected = turn == selectedTurn
            UnsaTurnChip(
                turn = turn,
                isSelected = isSelected,
                onClick = { onTurnSelected(turn) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}
