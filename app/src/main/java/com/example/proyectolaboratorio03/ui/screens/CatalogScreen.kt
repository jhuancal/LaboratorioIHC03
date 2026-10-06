package com.example.proyectolaboratorio03.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyectolaboratorio03.model.MockData
import com.example.proyectolaboratorio03.model.WorkshopCategory
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaSearchField
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaSectionTitle
import com.example.proyectolaboratorio03.ui.designsystem.organisms.UnsaCategoryCard
import com.example.proyectolaboratorio03.ui.designsystem.organisms.UnsaHeader
import com.example.proyectolaboratorio03.ui.theme.UnsaGreenSurface

/**
 * Pantalla 3: Catálogo de Talleres Extracurriculares
 * Alimentada por la clase WorkshopCategory y MockData.
 */
@Composable
fun CatalogScreen(
    onBackClick: () -> Unit,
    onCategoryClick: (String) -> Unit,
    categories: List<WorkshopCategory> = MockData.categories,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredCategories = remember(searchQuery, categories) {
        if (searchQuery.isBlank()) {
            categories
        } else {
            categories.filter { it.label.contains(searchQuery, ignoreCase = true) }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(UnsaGreenSurface)
    ) {
        UnsaHeader(
            title = "Catálogo",
            subtitle = "Talleres extracurriculares",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
                .padding(20.dp)
        ) {
            UnsaSearchField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = "Buscar taller..."
            )

            Spacer(modifier = Modifier.height(24.dp))

            UnsaSectionTitle(text = "Categorías")

            filteredCategories.chunked(2).forEach { rowPair ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    UnsaCategoryCard(
                        label = rowPair[0].label,
                        icon = rowPair[0].icon,
                        count = rowPair[0].count,
                        accentColor = rowPair[0].color,
                        onClick = { onCategoryClick(rowPair[0].label) },
                        modifier = Modifier.weight(1f)
                    )

                    if (rowPair.size > 1) {
                        UnsaCategoryCard(
                            label = rowPair[1].label,
                            icon = rowPair[1].icon,
                            count = rowPair[1].count,
                            accentColor = rowPair[1].color,
                            onClick = { onCategoryClick(rowPair[1].label) },
                            modifier = Modifier.weight(1f)
                        )
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
