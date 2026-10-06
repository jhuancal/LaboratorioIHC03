package com.example.proyectolaboratorio03.model

/**
 * Clase de Dominio: Taller Extracurricular
 * Representa una actividad extracurricular ofertada por la UNSA.
 */
data class Workshop(
    val id: String,
    val name: String,
    val category: String,
    val iconEmoji: String,
    val daySummary: String,
    val timeSummary: String,
    val availableSlots: Int,
    val isUrgent: Boolean,
    val hasAction: Boolean = false,
    val groups: List<WorkshopGroup> = emptyList()
)
