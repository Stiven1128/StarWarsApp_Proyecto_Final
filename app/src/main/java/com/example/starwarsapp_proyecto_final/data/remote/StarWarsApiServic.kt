package com.example.starwarsapp_proyecto_final.data.remote

import com.example.starwarsapp_proyecto_final.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApiService {

    @GET("people/")
    suspend fun getPeople(): PeopleResponse

    @GET("people/{id}/")
    suspend fun getPersonById(@Path("id") id: Int): Person

    @GET("films/")
    suspend fun getFilms(): FilmsResponse

    @GET("films/{id}/")
    suspend fun getFilmById(@Path("id") id: Int): Film

    @GET("planets/")
    suspend fun getPlanets(): PlanetsResponse

    @GET("starships/")
    suspend fun getStarships(): StarshipsResponse

    @GET("vehicles/")
    suspend fun getVehicles(): VehiclesResponse
}