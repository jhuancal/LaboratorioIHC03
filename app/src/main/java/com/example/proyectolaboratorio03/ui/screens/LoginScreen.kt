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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaInputField
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaPrimaryButton
import com.example.proyectolaboratorio03.ui.designsystem.organisms.UnsaLoginHeader
import com.example.proyectolaboratorio03.ui.theme.ProyectoLaboratorio03Theme
import com.example.proyectolaboratorio03.ui.theme.UnsaGold
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Pantalla 1: Login Institucional UNSA
 * Ensamblada usando Atoms y Organisms, respetando los insets del sistema.
 */
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    modifier: Modifier = Modifier
) {
    var codigo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White)
    ) {
        // Cabecera institucional con statusBarsPadding
        UnsaLoginHeader()

        // Formulario con scroll y navigationBarsPadding
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
                .padding(horizontal = 24.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            UnsaInputField(
                value = codigo,
                onValueChange = { codigo = it },
                label = "Código Institucional",
                placeholder = "20210001",
                keyboardType = KeyboardType.Number
            )

            UnsaInputField(
                value = password,
                onValueChange = { password = it },
                label = "Contraseña",
                placeholder = "••••••••",
                isPassword = true
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Botón de ingreso sin validaciones complejas
            UnsaPrimaryButton(
                text = "INGRESAR",
                onClick = onLoginSuccess
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "¿Olvidaste tu contraseña? ",
                    color = UnsaGreen.copy(alpha = 0.6f),
                    fontSize = 13.sp
                )
                Text(
                    text = "Recuperar",
                    color = UnsaGold,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
private fun LoginScreenPreview() {
    ProyectoLaboratorio03Theme {
        LoginScreen(
            onLoginSuccess = {}
        )
    }
}
