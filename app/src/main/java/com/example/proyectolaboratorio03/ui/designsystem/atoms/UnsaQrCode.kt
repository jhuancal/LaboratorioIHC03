package com.example.proyectolaboratorio03.ui.designsystem.atoms

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen

/**
 * Atom: Código QR vectorial de comprobante digital dibujado con Canvas
 */
@Composable
fun UnsaQrCode(
    modifier: Modifier = Modifier,
    size: Dp = 160.dp,
    color: Color = UnsaGreen
) {
    val pattern = listOf(
        listOf(1,1,1,1,1,1,1,0,1,0,1,0,0,0,1,1,1,1,1,1,1),
        listOf(1,0,0,0,0,0,1,0,0,1,0,1,1,0,1,0,0,0,0,0,1),
        listOf(1,0,1,1,1,0,1,0,1,0,1,0,0,0,1,0,1,1,1,0,1),
        listOf(1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,1),
        listOf(1,0,1,1,1,0,1,0,1,0,0,0,1,0,1,0,1,1,1,0,1),
        listOf(1,0,0,0,0,0,1,0,0,1,0,1,0,0,1,0,0,0,0,0,1),
        listOf(1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1),
        listOf(0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0),
        listOf(1,0,1,1,0,1,1,1,0,1,1,0,1,1,1,0,1,1,0,1,0),
        listOf(0,1,0,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,1),
        listOf(1,1,1,0,1,1,1,0,0,1,1,0,1,1,1,0,1,0,1,1,0),
        listOf(0,1,0,1,0,0,0,1,1,0,0,1,0,0,0,1,0,1,0,0,1),
        listOf(1,0,0,0,1,0,1,0,1,1,0,0,1,1,1,0,0,0,1,0,0),
        listOf(0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,1,0,1,0,1,1),
        listOf(1,1,1,1,1,1,1,0,0,1,0,0,1,0,1,0,1,0,0,1,0),
        listOf(1,0,0,0,0,0,1,0,1,0,1,1,0,1,0,1,0,1,1,0,1),
        listOf(1,0,1,1,1,0,1,0,0,1,0,0,1,0,1,0,0,0,0,1,0),
        listOf(1,0,1,1,1,0,1,0,1,0,1,1,0,1,0,1,1,1,1,0,1),
        listOf(1,0,1,1,1,0,1,0,0,1,0,0,1,0,1,0,0,0,0,0,1),
        listOf(1,0,0,0,0,0,1,0,1,0,1,1,0,1,0,1,1,1,1,1,1),
        listOf(1,1,1,1,1,1,1,0,0,1,0,0,1,0,1,0,0,0,0,0,0)
    )

    Canvas(modifier = modifier.size(size)) {
        val totalCells = 21
        val cellPixelSize = size.toPx() / totalCells
        val cellDrawSize = cellPixelSize * 0.95f

        for (r in 0 until totalCells) {
            for (c in 0 until totalCells) {
                if (pattern[r][c] == 1) {
                    drawRect(
                        color = color,
                        topLeft = Offset(c * cellPixelSize, r * cellPixelSize),
                        size = Size(cellDrawSize, cellDrawSize)
                    )
                }
            }
        }
    }
}
