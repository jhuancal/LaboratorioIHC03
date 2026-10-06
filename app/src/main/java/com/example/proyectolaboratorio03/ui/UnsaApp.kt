package com.example.proyectolaboratorio03.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.proyectolaboratorio03.ui.screens.CatalogScreen
import com.example.proyectolaboratorio03.ui.screens.DashboardScreen
import com.example.proyectolaboratorio03.ui.screens.ErrorScreen
import com.example.proyectolaboratorio03.ui.screens.GroupScreen
import com.example.proyectolaboratorio03.ui.screens.LoadingScreen
import com.example.proyectolaboratorio03.ui.screens.LoginScreen
import com.example.proyectolaboratorio03.ui.screens.ResultsScreen
import com.example.proyectolaboratorio03.ui.screens.SuccessScreen
import com.example.proyectolaboratorio03.ui.screens.TimeFilterScreen
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenSurface
import kotlinx.coroutines.delay

enum class ScreenDestination {
    LOGIN,
    DASHBOARD,
    CATALOG,
    FILTER,
    RESULTS,
    GROUP,
    LOADING,
    ERROR,
    SUCCESS
}

/**
 * Orquestador principal de la aplicación.
 * Flujo de navegación limpio y directo entre pantallas sin barras simuladas ni validaciones bloqueantes.
 */
@Composable
fun UnsaApp(
    modifier: Modifier = Modifier
) {
    var currentScreen by remember { mutableStateOf(ScreenDestination.LOGIN) }

    // Manejo del botón 'Atrás' nativo de Android
    BackHandler(enabled = currentScreen != ScreenDestination.LOGIN) {
        currentScreen = when (currentScreen) {
            ScreenDestination.LOGIN -> ScreenDestination.LOGIN
            ScreenDestination.DASHBOARD -> ScreenDestination.LOGIN
            ScreenDestination.CATALOG -> ScreenDestination.DASHBOARD
            ScreenDestination.FILTER -> ScreenDestination.DASHBOARD
            ScreenDestination.RESULTS -> ScreenDestination.DASHBOARD
            ScreenDestination.GROUP -> ScreenDestination.RESULTS
            ScreenDestination.LOADING -> ScreenDestination.GROUP
            ScreenDestination.ERROR -> ScreenDestination.GROUP
            ScreenDestination.SUCCESS -> ScreenDestination.DASHBOARD
        }
    }

    // Transición automática de carga a confirmación exitosa
    LaunchedEffect(currentScreen) {
        if (currentScreen == ScreenDestination.LOADING) {
            delay(2500)
            if (currentScreen == ScreenDestination.LOADING) {
                currentScreen = ScreenDestination.SUCCESS
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(UnsaGreenSurface)
    ) {
        AnimatedContent(
            targetState = currentScreen,
            transitionSpec = { fadeIn() togetherWith fadeOut() },
            label = "screenTransition"
        ) { destination ->
            when (destination) {
                ScreenDestination.LOGIN -> {
                    LoginScreen(
                        onLoginSuccess = { currentScreen = ScreenDestination.DASHBOARD }
                    )
                }

                ScreenDestination.DASHBOARD -> {
                    DashboardScreen(
                        onMethod1Click = { currentScreen = ScreenDestination.FILTER },
                        onMethod2Click = { currentScreen = ScreenDestination.CATALOG }
                    )
                }

                ScreenDestination.CATALOG -> {
                    CatalogScreen(
                        onBackClick = { currentScreen = ScreenDestination.DASHBOARD },
                        onCategoryClick = { _ -> currentScreen = ScreenDestination.RESULTS }
                    )
                }

                ScreenDestination.FILTER -> {
                    TimeFilterScreen(
                        onBackClick = { currentScreen = ScreenDestination.DASHBOARD },
                        onApplyFilter = { _ -> currentScreen = ScreenDestination.RESULTS }
                    )
                }

                ScreenDestination.RESULTS -> {
                    ResultsScreen(
                        onBackClick = { currentScreen = ScreenDestination.DASHBOARD },
                        onWorkshopSelected = { _ -> currentScreen = ScreenDestination.GROUP }
                    )
                }

                ScreenDestination.GROUP -> {
                    GroupScreen(
                        workshopName = "Fútsal",
                        onBackClick = { currentScreen = ScreenDestination.RESULTS },
                        onConfirmEnrollment = { _ -> currentScreen = ScreenDestination.LOADING }
                    )
                }

                ScreenDestination.LOADING -> {
                    LoadingScreen(
                        onCancelClick = { currentScreen = ScreenDestination.ERROR }
                    )
                }

                ScreenDestination.ERROR -> {
                    ErrorScreen(
                        onRetryClick = { currentScreen = ScreenDestination.LOADING }
                    )
                }

                ScreenDestination.SUCCESS -> {
                    SuccessScreen(
                        onHomeClick = { currentScreen = ScreenDestination.DASHBOARD }
                    )
                }
            }
        }
    }
}
