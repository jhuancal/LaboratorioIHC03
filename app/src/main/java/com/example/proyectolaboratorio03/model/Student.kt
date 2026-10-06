package com.example.proyectolaboratorio03.model

/**
 * Clase de Dominio: Estudiante Universitario
 * Representa los datos institucionales del alumno logueado en la aplicación.
 */
data class Student(
    val code: String,
    val firstName: String,
    val lastName: String,
    val semester: String,
    val enrolledWorkshopsCount: Int,
    val availableSlotsCount: Int,
    val accumulatedCredits: Int
) {
    val fullName: String get() = "$firstName $lastName"
}
