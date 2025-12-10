package com.example.starwarsapp_proyecto_final.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsapp_proyecto_final.data.model.Person
import com.example.starwarsapp_proyecto_final.data.repository.StarWarsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PeopleViewModel : ViewModel() {

    private val repository = StarWarsRepository()

    private val _people = MutableStateFlow<List<Person>>(emptyList())
    val people: StateFlow<List<Person>> = _people

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        loadPeople()
    }

    fun loadPeople() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = repository.getPeople()
                _people.value = response.results
            } catch (e: Exception) {
                _error.value = "Error al cargar personajes: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun searchPeople(query: String): List<Person> {
        return if (query.isEmpty()) {
            _people.value
        } else {
            _people.value.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }
    }
}