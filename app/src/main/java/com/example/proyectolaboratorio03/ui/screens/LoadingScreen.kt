package com.example.proyectolaboratorio03.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.model.MockData
import com.example.proyectolaboratorio03.model.ProcessStep
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaDangerButton
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaSpinner
import com.example.proyectolaboratorio03.ui.designsystem.organisms.UnsaProcessProgressCard
import com.example.proyectolaboratorio03.ui.theme.Gray400
import com.example.proyectolaboratorio03.ui.theme.Gray500
import com.example.proyectolaboratorio03.ui.theme.ProyectoLaboratorio03Theme
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Pantalla 7: Estado de Carga y Procesamiento de Inscripción
 * Alimentada por la clase ProcessStep y MockData.
 */
@Composable
fun LoadingScreen(
    onCancelClick: () -> Unit,
    steps: List<ProcessStep> = MockData.enrollmentSteps,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            UnsaSpinner(size = 80.dp)

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Procesando inscripción",
                color = UnsaGreen,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "conectando con el servidor...",
                color = Gray500,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            UnsaProcessProgressCard(
                steps = steps.map { it.label to it.isDone }
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Este proceso puede tardar unos segundos",
                color = Gray400,
                fontSize = 12.sp
            )

            UnsaDangerButton(
                text = "Cancelar inscripción",
                onClick = onCancelClick
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
private fun LoadingScreenPreview() {
    ProyectoLaboratorio03Theme {
        LoadingScreen(
            onCancelClick = {}
        )
    }
}
