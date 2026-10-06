package com.example.proyectolaboratorio03.model

import com.example.proyectolaboratorio03.ui.theme.CategoryArtes
import com.example.proyectolaboratorio03.ui.theme.CategoryBienestar
import com.example.proyectolaboratorio03.ui.theme.CategoryDeportes
import com.example.proyectolaboratorio03.ui.theme.CategoryIdiomas
import com.example.proyectolaboratorio03.ui.theme.CategoryMusica
import com.example.proyectolaboratorio03.ui.theme.CategoryTecnologia

/**
 * Fuente de Datos Simulada (Mock Data) para el flujo de la aplicación UNSA.
 * Proporciona instancias listas para consumir en la UI sin necesidad de backend o red.
 */
object MockData {

    /**
     * Estudiante autenticado en sesión
     */
    val currentStudent = Student(
        code = "20210001",
        firstName = "Carlos",
        lastName = "Mamani",
        semester = "Semestre 2026-I",
        enrolledWorkshopsCount = 2,
        availableSlotsCount = 8,
        accumulatedCredits = 4
    )

    /**
     * Categorías del catálogo de talleres extracurriculares
     */
    val categories: List<WorkshopCategory> = listOf(
        WorkshopCategory(
            id = "cat_deportes",
            label = "Deportes",
            icon = "⚽",
            count = 12,
            color = CategoryDeportes
        ),
        WorkshopCategory(
            id = "cat_artes",
            label = "Artes",
            icon = "🎨",
            count = 8,
            color = CategoryArtes
        ),
        WorkshopCategory(
            id = "cat_tecnologia",
            label = "Tecnología",
            icon = "💻",
            count = 10,
            color = CategoryTecnologia
        ),
        WorkshopCategory(
            id = "cat_musica",
            label = "Música",
            icon = "🎵",
            count = 6,
            color = CategoryMusica
        ),
        WorkshopCategory(
            id = "cat_idiomas",
            label = "Idiomas",
            icon = "🌐",
            count = 9,
            color = CategoryIdiomas
        ),
        WorkshopCategory(
            id = "cat_bienestar",
            label = "Bienestar",
            icon = "🧘",
            count = 5,
            color = CategoryBienestar
        )
    )

    /**
     * Comisiones y grupos de Fútsal
     */
    val futsalGroups: List<WorkshopGroup> = listOf(
        WorkshopGroup(
            id = 1,
            name = "Grupo 01",
            instructor = "Prof. Rivera",
            schedule = "Lun · 14:00 – 16:00",
            availableSlots = 15,
            isFull = false,
            isCritical = false
        ),
        WorkshopGroup(
            id = 2,
            name = "Grupo 02",
            instructor = "Prof. Quispe",
            schedule = "Mié · 16:00 – 18:00",
            availableSlots = 4,
            isFull = false,
            isCritical = true
        ),
        WorkshopGroup(
            id = 3,
            name = "Grupo 03",
            instructor = "Prof. Cárdenas",
            schedule = "Vie · 10:00 – 12:00",
            availableSlots = 0,
            isFull = true,
            isCritical = false
        )
    )

    /**
     * Resultados de búsqueda de talleres
     */
    val workshops: List<Workshop> = listOf(
        Workshop(
            id = "w_futsal",
            name = "Fútsal",
            category = "Deportes",
            iconEmoji = "⚽",
            daySummary = "Mié · Tarde",
            timeSummary = "16:00 – 18:00",
            availableSlots = 4,
            isUrgent = true,
            hasAction = true,
            groups = futsalGroups
        ),
        Workshop(
            id = "w_pintura",
            name = "Pintura al Óleo",
            category = "Artes",
            iconEmoji = "🎨",
            daySummary = "Lun · Mañana",
            timeSummary = "09:00 – 11:00",
            availableSlots = 12,
            isUrgent = false,
            hasAction = false
        ),
        Workshop(
            id = "w_yoga",
            name = "Yoga & Mindfulness",
            category = "Bienestar",
            iconEmoji = "🧘",
            daySummary = "Jue · Tarde",
            timeSummary = "15:00 – 16:30",
            availableSlots = 9,
            isUrgent = false,
            hasAction = false
        ),
        Workshop(
            id = "w_programacion",
            name = "Programación Web",
            category = "Tecnología",
            iconEmoji = "💻",
            daySummary = "Mar · Noche",
            timeSummary = "19:00 – 21:00",
            availableSlots = 2,
            isUrgent = true,
            hasAction = false
        )
    )

    /**
     * Pasos del proceso de registro para la pantalla de carga
     */
    val enrollmentSteps: List<ProcessStep> = listOf(
        ProcessStep(id = 1, label = "Validando datos", isDone = true),
        ProcessStep(id = 2, label = "Verificando cupos", isDone = true),
        ProcessStep(id = 3, label = "Registrando inscripción", isDone = false)
    )

    /**
     * Comprobante oficial digital emitido tras la inscripción exitosa
     */
    val sampleVoucher = EnrollmentVoucher(
        id = "VOUCHER-2026-00492",
        workshopName = "Fútsal",
        groupName = "Grupo 02",
        studentName = "Carlos Mamani",
        studentCode = "20210001",
        schedule = "Mié 16:00 – 18:00",
        instructor = "Prof. Quispe",
        semesterBadge = "UNSA 2026-I · VÁLIDO",
        syncState = SyncState.SAVED_LOCALLY,
        qrToken = "UNSA_EXTRACURRICULARES_2026_I_MAMANI_CARLOS_FUTSAL_G02"
    )

    /**
     * Días y turnos disponibles para selección
     */
    val availableDays = listOf("Lun", "Mar", "Mié", "Jue", "Vie")
    val availableTurns = listOf("Mañana", "Tarde", "Noche")

    val defaultTimeFilter = TimeFilter(
        selectedDays = setOf("Mié"),
        selectedTurn = "Tarde",
        onlyFreeBlocks = true
    )
}
