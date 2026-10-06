package com.example.proyectolaboratorio03.ui.designsystem.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.theme.CardShape
import com.example.proyectolaboratorio03.ui.theme.Gray300
import com.example.proyectolaboratorio03.ui.theme.Gray400
import com.example.proyectolaboratorio03.ui.theme.Gray800
import com.example.proyectolaboratorio03.ui.theme.InputShape
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenSurface
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Atom: Campo de entrada de texto estético UNSA (Login y Formularios)
 */
@Composable
fun UnsaInputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label.uppercase(),
            color = UnsaGreen,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.2.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(InputShape)
                .background(UnsaGreenSurface)
                .border(2.dp, UnsaGreen.copy(alpha = 0.3f), InputShape)
                .padding(horizontal = 16.dp),
            textStyle = TextStyle(
                color = Gray800,
                fontSize = 17.sp,
                fontWeight = FontWeight.Normal
            ),
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            cursorBrush = SolidColor(UnsaGreen),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (value.isEmpty() && placeholder.isNotEmpty()) {
                        Text(
                            text = placeholder,
                            color = Gray300,
                            fontSize = 17.sp
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}

/**
 * Atom: Barra de búsqueda con icono de lupa (Catálogo)
 */
@Composable
fun UnsaSearchField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "Buscar taller...",
    modifier: Modifier = Modifier
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(CardShape)
            .background(White)
            .border(2.dp, UnsaGreen.copy(alpha = 0.25f), CardShape)
            .padding(horizontal = 16.dp),
        textStyle = TextStyle(
            color = Gray800,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        ),
        singleLine = true,
        cursorBrush = SolidColor(UnsaGreen),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = UnsaGreen,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Box(modifier = Modifier.weight(1f)) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = Gray400,
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }
            }
        }
    )
}
