package com.example.proyectolaboratorio03.ui.designsystem.atoms

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenContainer

/**
 * Atom: Indicador de carga animado (Spinner circular con los colores de marca)
 */
@Composable
fun UnsaSpinner(
    modifier: Modifier = Modifier,
    size: Dp = 80.dp,
    strokeWidth: Dp = 6.dp,
    color: Color = UnsaGreen,
    trackColor: Color = UnsaGreenContainer
) {
    val transition = rememberInfiniteTransition(label = "spinnerTransition")
    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing)
        ),
        label = "spinnerRotation"
    )

    Canvas(modifier = modifier.size(size)) {
        // Track
        drawCircle(
            color = trackColor,
            radius = size.toPx() / 2 - strokeWidth.toPx() / 2,
            style = Stroke(width = strokeWidth.toPx())
        )
        // Spinning Arc
        drawArc(
            color = color,
            startAngle = rotation,
            sweepAngle = 100f,
            useCenter = false,
            style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
        )
    }
}
