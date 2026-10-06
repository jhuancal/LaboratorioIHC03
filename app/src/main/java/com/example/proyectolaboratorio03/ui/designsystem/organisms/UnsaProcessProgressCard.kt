package com.example.proyectolaboratorio03.ui.designsystem.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyectolaboratorio03.ui.designsystem.molecules.UnsaProgressStepItem

/**
 * Organism: Lista de pasos del proceso de validación e inscripción
 */
@Composable
fun UnsaProcessProgressCard(
    steps: List<Pair<String, Boolean>>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        steps.forEach { (label, done) ->
            UnsaProgressStepItem(
                label = label,
                isDone = done
            )
        }
    }
}
