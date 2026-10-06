package com.example.proyectolaboratorio03.model

/**
 * Clase de Dominio: Filtro de Búsqueda de Horarios
 * Contiene el estado de los filtros seleccionados por el alumno.
 */
data class TimeFilter(
    val selectedDays: Set<String> = setOf("Mié"),
    val selectedTurn: String = "Tarde",
    val onlyFreeBlocks: Boolean = true
) {
    val summaryText: String
        get() = buildString {
            if (selectedDays.isNotEmpty()) {
                append(selectedDays.joinToString(", "))
                append(" · ")
            }
            append(selectedTurn)
            if (onlyFreeBlocks) {
                append(" · Solo libres")
            }
        }
}
