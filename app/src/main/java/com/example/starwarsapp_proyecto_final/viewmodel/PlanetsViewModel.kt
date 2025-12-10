package com.example.starwarsapp_proyecto_final.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsapp_proyecto_final.data.model.Planet
import com.example.starwarsapp_proyecto_final.data.repository.StarWarsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlanetsViewModel : ViewModel() {

    private val repository = StarWarsRepository()

    private val _planets = MutableStateFlow<List<Planet>>(emptyList())
    val planets: StateFlow<List<Planet>> = _planets

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        loadPlanets()
    }

    fun loadPlanets() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = repository.getPlanets()
                _planets.value = response.results
            } catch (e: Exception) {
                _error.value = "Error al cargar planetas: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}