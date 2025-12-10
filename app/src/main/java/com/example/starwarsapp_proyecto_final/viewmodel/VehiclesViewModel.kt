package com.example.starwarsapp_proyecto_final.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsapp_proyecto_final.data.model.Vehicle
import com.example.starwarsapp_proyecto_final.data.repository.StarWarsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VehiclesViewModel : ViewModel() {

    private val repository = StarWarsRepository()

    private val _vehicles = MutableStateFlow<List<Vehicle>>(emptyList())
    val vehicles: StateFlow<List<Vehicle>> = _vehicles

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        loadVehicles()
    }

    fun loadVehicles() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = repository.getVehicles()
                _vehicles.value = response.results
            } catch (e: Exception) {
                _error.value = "Error al cargar vehículos: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}