package com.example.starwarsapp_proyecto_final.data.model

data class Planet(
    val name: String,
    val climate: String,
    val terrain: String,
    val population: String,
    val diameter: String
)

data class PlanetsResponse(
    val count: Int,
    val results: List<Planet>
)