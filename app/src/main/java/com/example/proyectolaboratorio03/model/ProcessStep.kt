package com.example.proyectolaboratorio03.model

/**
 * Clase de Dominio: Paso en el Flujo de Procesamiento
 * Representa cada fase de verificación durante el registro.
 */
data class ProcessStep(
    val id: Int,
    val label: String,
    val isDone: Boolean
)
