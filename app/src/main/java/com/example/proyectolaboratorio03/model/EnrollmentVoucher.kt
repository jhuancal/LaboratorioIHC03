package com.example.proyectolaboratorio03.model

/**
 * Estado de Sincronización del Comprobante
 */
enum class SyncState {
    SYNCED,
    SAVED_LOCALLY,
    PENDING
}

/**
 * Clase de Dominio: Comprobante Digital de Inscripción Oficial
 * Representa la constancia final generada con código QR y validez institucional.
 */
data class EnrollmentVoucher(
    val id: String,
    val workshopName: String,
    val groupName: String,
    val studentName: String,
    val studentCode: String,
    val schedule: String,
    val instructor: String,
    val semesterBadge: String,
    val syncState: SyncState = SyncState.SAVED_LOCALLY,
    val qrToken: String
) {
    val displayHeader: String get() = "$workshopName · $groupName"
    val displayStudent: String get() = "$studentName · $studentCode"
    val displaySchedule: String get() = "$schedule · $instructor"
}
