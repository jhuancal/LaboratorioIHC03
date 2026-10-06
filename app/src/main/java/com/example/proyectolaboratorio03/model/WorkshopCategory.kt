package com.example.proyectolaboratorio03.model

import androidx.compose.ui.graphics.Color

/**
 * Clase de Dominio: Categoría de Taller Extracurricular
 * Representa cada área (Deportes, Artes, Tecnología, etc.) en el catálogo.
 */
data class WorkshopCategory(
    val id: String,
    val label: String,
    val icon: String,
    val count: Int,
    val color: Color
)
