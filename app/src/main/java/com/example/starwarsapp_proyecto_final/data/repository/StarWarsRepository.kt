package com.example.starwarsapp_proyecto_final.data.repository

import com.example.starwarsapp_proyecto_final.data.model.*
import com.example.starwarsapp_proyecto_final.data.remote.RetrofitInstance

class StarWarsRepository {

    private val api = RetrofitInstance.api

    suspend fun getPeople(): PeopleResponse {
        return api.getPeople()
    }

    suspend fun getPersonById(id: Int): Person {
        return api.getPersonById(id)
    }

    suspend fun getFilms(): FilmsResponse {
        return api.getFilms()
    }

    suspend fun getFilmById(id: Int): Film {
        return api.getFilmById(id)
    }

    suspend fun getPlanets(): PlanetsResponse {
        return api.getPlanets()
    }

    suspend fun getStarships(): StarshipsResponse {
        return api.getStarships()
    }

    suspend fun getVehicles(): VehiclesResponse {
        return api.getVehicles()
    }
}