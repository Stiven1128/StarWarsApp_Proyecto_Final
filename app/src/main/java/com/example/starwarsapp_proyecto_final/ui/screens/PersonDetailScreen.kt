package com.example.starwarsapp_proyecto_final.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.starwarsapp_proyecto_final.data.model.Person
import com.example.starwarsapp_proyecto_final.data.repository.StarWarsRepository
import com.example.starwarsapp_proyecto_final.ui.components.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PersonDetailViewModel : ViewModel() {
    private val repository = StarWarsRepository()

    private val _person = MutableStateFlow<Person?>(null)
    val person: StateFlow<Person?> = _person

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun loadPerson(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                _person.value = repository.getPersonById(id)
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonDetailScreen(
    personId: Int,
    onNavigateBack: () -> Unit,
    viewModel: PersonDetailViewModel = viewModel()
) {
    val person by viewModel.person.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(personId) {
        viewModel.loadPerson(personId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        person?.name ?: "Cargando...",
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
        Box(modifier = Modifier.fillMaxSize()) {
            StarfieldBackground()

            when {
                isLoading -> LoadingScreen("Cargando detalles...")
                error != null -> ErrorScreen(
                    errorMessage = error ?: "Error desconocido",
                    onRetry = { viewModel.loadPerson(personId) }
                )
                else -> {
                    person?.let { p ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                                .padding(16.dp)
                                .verticalScroll(rememberScrollState()),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // Avatar grande
                            CharacterAvatar(
                                name = p.name,
                                size = 120
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            // Tarjeta de información
                            GlowingCard(modifier = Modifier.fillMaxWidth()) {
                                SectionTitle("INFORMACIÓN PERSONAL")
                                Spacer(modifier = Modifier.height(8.dp))
                                InfoRow(
                                    icon = "👤",
                                    label = "Nombre",
                                    value = p.name
                                )
                                InfoRow(
                                    icon = "📏",
                                    label = "Altura",
                                    value = "${p.height} cm"
                                )
                                InfoRow(
                                    icon = "⚖️",
                                    label = "Peso",
                                    value = "${p.mass} kg"
                                )
                                InfoRow(
                                    icon = "🚻",
                                    label = "Género",
                                    value = p.gender
                                )
                                InfoRow(
                                    icon = "🎂",
                                    label = "Año de nacimiento",
                                    value = p.birth_year,
                                    showDivider = false
                                )
                            }

                            // Tarjeta de películas
                            GlowingCard(modifier = Modifier.fillMaxWidth()) {
                                SectionTitle("PELÍCULAS")
                                Spacer(modifier = Modifier.height(8.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "🎬",
                                        style = MaterialTheme.typography.displaySmall
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Column {
                                        Text(
                                            text = "Apariciones",
                                            style = MaterialTheme.typography.labelLarge,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                        Text(
                                            text = "${p.films.size} películas",
                                            style = MaterialTheme.typography.titleLarge,
                                            color = MaterialTheme.colorScheme.onSurface,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}