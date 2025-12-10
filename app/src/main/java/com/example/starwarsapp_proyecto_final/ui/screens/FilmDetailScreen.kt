package com.example.starwarsapp_proyecto_final.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.starwarsapp_proyecto_final.data.model.Film
import com.example.starwarsapp_proyecto_final.data.repository.StarWarsRepository
import com.example.starwarsapp_proyecto_final.ui.components.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FilmDetailViewModel : ViewModel() {
    private val repository = StarWarsRepository()

    private val _film = MutableStateFlow<Film?>(null)
    val film: StateFlow<Film?> = _film

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun loadFilm(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _film.value = repository.getFilmById(id)
            } catch (e: Exception) {
                // Manejar error
            } finally {
                _isLoading.value = false
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmDetailScreen(
    filmId: Int,
    onNavigateBack: () -> Unit,
    viewModel: FilmDetailViewModel = viewModel()
) {
    val film by viewModel.film.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(filmId) {
        viewModel.loadFilm(filmId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        film?.title ?: "Cargando...",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.Default.ArrowBack,
                            "Volver",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        if (isLoading) {
            LoadingScreen("Cargando película...")
        } else {
            film?.let { f ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    StarWarsCard(modifier = Modifier.fillMaxWidth()) {
                        SectionTitle("INFORMACIÓN")
                        Spacer(modifier = Modifier.height(8.dp))
                        InfoRow(
                            icon = "📺",
                            label = "Episodio",
                            value = "${f.episode_id}"
                        )
                        InfoRow(
                            icon = "🎬",
                            label = "Director",
                            value = f.director
                        )
                        InfoRow(
                            icon = "🎥",
                            label = "Productor",
                            value = f.producer
                        )
                        InfoRow(
                            icon = "📅",
                            label = "Fecha de estreno",
                            value = f.release_date,
                            showDivider = false
                        )
                    }

                    StarWarsCard(modifier = Modifier.fillMaxWidth()) {
                        SectionTitle("SINOPSIS")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = f.opening_crawl,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    StarWarsCard(modifier = Modifier.fillMaxWidth()) {
                        SectionTitle("PERSONAJES")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "👥 Total: ${f.characters.size} personajes",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}