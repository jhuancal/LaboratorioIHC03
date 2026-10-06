package com.example.proyectolaboratorio03.ui.designsystem.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.ui.theme.ButtonShape
import com.example.proyectolaboratorio03.ui.theme.UnsaGold
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenDark
import com.example.proyectolaboratorio03.ui.theme.UnsaRed
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Atom: Botón Primario UNSA (Verde Institucional)
 */
@Composable
fun UnsaPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    height: Dp = 60.dp,
    icon: (@Composable RowScope.() -> Unit)? = null
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(height),
        enabled = enabled,
        shape = ButtonShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = UnsaGreen,
            contentColor = White,
            disabledContainerColor = UnsaGreen.copy(alpha = 0.4f),
            disabledContentColor = White.copy(alpha = 0.7f)
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp, pressedElevation = 2.dp),
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) {
        if (icon != null) {
            icon()
        }
        Text(
            text = text.uppercase(),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.2.sp
        )
    }
}

/**
 * Atom: Botón Secundario UNSA (Dorado/Ámbar de acción destacada)
 */
@Composable
fun UnsaSecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    height: Dp = 60.dp
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(height),
        enabled = enabled,
        shape = ButtonShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = UnsaGold,
            contentColor = UnsaGreenDark,
            disabledContainerColor = UnsaGold.copy(alpha = 0.4f),
            disabledContentColor = UnsaGreenDark.copy(alpha = 0.6f)
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp, pressedElevation = 2.dp),
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) {
        Text(
            text = text.uppercase(),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.2.sp
        )
    }
}

/**
 * Atom: Botón con Borde (Outlined)
 */
@Composable
fun UnsaOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    borderColor: Color = UnsaGreen,
    contentColor: Color = UnsaGreen,
    height: Dp = 56.dp,
    icon: (@Composable RowScope.() -> Unit)? = null
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(height),
        shape = ButtonShape,
        border = BorderStroke(2.dp, borderColor),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = contentColor
        ),
        contentPadding = PaddingValues(horizontal = 20.dp)
    ) {
        if (icon != null) {
            icon()
        }
        Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp
        )
    }
}

/**
 * Atom: Botón de Peligro / Cancelación
 */
@Composable
fun UnsaDangerButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 56.dp
) {
    UnsaOutlinedButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        borderColor = UnsaRed,
        contentColor = UnsaRed,
        height = height
    )
}

/**
 * Atom: Botón Circular para Barra Superior (Atrás, Acción)
 */
@Composable
fun UnsaCircleBackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = White,
    backgroundColor: Color = White.copy(alpha = 0.15f)
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(backgroundColor)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Atrás",
            tint = tint,
            modifier = Modifier.size(20.dp)
        )
    }
}

/**
 * Atom: Chip seleccionable para Días
 */
@Composable
fun UnsaDayChip(
    day: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(48.dp),
        shape = CircleShape,
        border = BorderStroke(2.dp, if (isSelected) UnsaGreen else UnsaGreen.copy(alpha = 0.3f)),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) UnsaGreen else White,
            contentColor = if (isSelected) White else UnsaGreen
        ),
        elevation = if (isSelected) ButtonDefaults.buttonElevation(defaultElevation = 2.dp) else null,
        contentPadding = PaddingValues(horizontal = 20.dp)
    ) {
        Text(
            text = day,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/**
 * Atom: Botón de Turno (Mañana, Tarde, Noche)
 */
@Composable
fun UnsaTurnChip(
    turn: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(54.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, if (isSelected) UnsaGreen else UnsaGreen.copy(alpha = 0.3f)),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) UnsaGreen else White,
            contentColor = if (isSelected) White else UnsaGreen
        ),
        elevation = if (isSelected) ButtonDefaults.buttonElevation(defaultElevation = 2.dp) else null,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        Text(
            text = turn,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun UnsaButtonsPreview() {
    UnsaPrimaryButton(text = "Ingresar", onClick = {})
}
