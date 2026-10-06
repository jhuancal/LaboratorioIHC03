# Laboratorio 03 - Interacción Humano-Computador (UNSA)

Aplicación móvil desarrollada en **Android con Jetpack Compose** para el Laboratorio 03 del curso de **Interacción Humano-Computador (IHC)** en la **Universidad Nacional de San Agustín de Arequipa (UNSA)**.

## 📱 Descripción del Proyecto

Sistema interactivo para la gestión y matrícula de estudiantes en talleres extracurriculares de la UNSA, implementado siguiendo principios de usabilidad, diseño centrado en el usuario y una arquitectura de componentes basada en **Atomic Design**.

### ✨ Características Principales
* **Autenticación Estudiantil**: Pantalla de inicio de sesión institucional.
* **Dashboard Principal**: Métricas del estudiante (créditos, talleres inscritos, cupos disponibles) y accesos directos.
* **Exploración de Talleres**:
  * Búsqueda por catálogo y categorías (Deportes, Idiomas, Arte, Música, Tecnología, Bienestar).
  * Filtrado avanzado por días y turnos horarios.
* **Selección de Grupos**: Visualización de cupos disponibles, docentes, horarios y aulas.
* **Flujo de Matrícula**: Pantalla de procesamiento y confirmación de inscripción.
* **Voucher Digital con Código QR**: Comprobante de inscripción con soporte de estado de sincronización.
* **Gestión de Errores y Carga**: Pantallas dedicadas para manejo de fallos y estados de espera.

---

## 🏗️ Arquitectura y Diseño UI (Atomic Design)

La interfaz está construida modularmente en Jetpack Compose:
* **Átomos (`atoms`)**: Botones personalizados (`UnsaButton`), Insignias (`UnsaBadge`), Campos de texto (`UnsaTextField`), Tipografías (`UnsaText`), Switch, QR, Spinner y Logos institucionales.
* **Moléculas (`molecules`)**: Selector de días (`UnsaDaySelectorRow`), Selector de turnos (`UnsaTurnSelectorRow`), Tarjetas estadísticas (`UnsaStatCard`), Chips de filtros (`UnsaFilterSummaryChip`), Indicador de sincronización (`UnsaSyncStatusCard`), entre otros.
* **Organismos (`organisms`)**: Tarjetas de taller (`UnsaWorkshopCard`), Tarjeta de grupo (`UnsaGroupCard`), Encabezados institucionales (`UnsaHeader`, `UnsaDashboardHeader`), Voucher digital (`UnsaDigitalVoucherCard`).
* **Pantallas (`screens`)**: Vistas completas orquestadas en `UnsaApp`.

---

## 🛠️ Tecnologías y Requisitos

* **Lenguaje**: Kotlin
* **UI Toolkit**: Jetpack Compose con Material 3
* **JDK**: Java 17 o superior
* **Herramienta de Construcción**: Gradle 8.x / 9.x con Kotlin DSL (`build.gradle.kts`)
* **IDE Recomendado**: Android Studio Ladybug / Meerkat o superior

---

## 🚀 Cómo Ejecutar el Proyecto

1. Clonar el repositorio:
   ```bash
   git clone git@github-unsa:jhuancal/LaboratorioIHC03.git
   ```
2. Abrir la carpeta del proyecto en Android Studio.
3. Permitir que Gradle sincronice las dependencias del proyecto.
4. Ejecutar en un emulador Android (API 26+) o dispositivo físico.
