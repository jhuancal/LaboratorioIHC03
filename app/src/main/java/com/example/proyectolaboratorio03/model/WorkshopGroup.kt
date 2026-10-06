package com.example.proyectolaboratorio03.model

/**
 * Clase de Dominio: Grupo y Horario de un Taller
 * Modela las comisiones disponibles para la inscripción.
 */
data class WorkshopGroup(
    val id: Int,
    val name: String,
    val instructor: String,
    val schedule: String,
    val availableSlots: Int,
    val isFull: Boolean,
    val isCritical: Boolean = false
)
