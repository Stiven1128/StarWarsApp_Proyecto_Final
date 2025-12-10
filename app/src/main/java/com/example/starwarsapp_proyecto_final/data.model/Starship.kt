package com.example.starwarsapp_proyecto_final.data.model

data class Starship(
    val name: String,
    val model: String,
    val manufacturer: String,
    val cost_in_credits: String,
    val length: String,
    val crew: String,
    val passengers: String
)

data class StarshipsResponse(
    val count: Int,
    val results: List<Starship>
)