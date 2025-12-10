package com.example.starwarsapp_proyecto_final.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsapp_proyecto_final.data.model.Starship
import com.example.starwarsapp_proyecto_final.data.repository.StarWarsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StarshipsViewModel : ViewModel() {

    private val repository = StarWarsRepository()

    private val _starships = MutableStateFlow<List<Starship>>(emptyList())
    val starships: StateFlow<List<Starship>> = _starships

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        loadStarships()
    }

    fun loadStarships() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = repository.getStarships()
                _starships.value = response.results
            } catch (e: Exception) {
                _error.value = "Error al cargar naves: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}