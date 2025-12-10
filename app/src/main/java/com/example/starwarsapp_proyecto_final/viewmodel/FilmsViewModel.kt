package com.example.starwarsapp_proyecto_final.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsapp_proyecto_final.data.model.Film
import com.example.starwarsapp_proyecto_final.data.repository.StarWarsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FilmsViewModel : ViewModel() {

    private val repository = StarWarsRepository()

    private val _films = MutableStateFlow<List<Film>>(emptyList())
    val films: StateFlow<List<Film>> = _films

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        loadFilms()
    }

    fun loadFilms() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = repository.getFilms()
                _films.value = response.results
            } catch (e: Exception) {
                _error.value = "Error al cargar películas: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}