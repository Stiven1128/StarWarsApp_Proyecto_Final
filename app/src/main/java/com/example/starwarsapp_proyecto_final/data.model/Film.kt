package com.example.starwarsapp_proyecto_final.data.model

data class Film(
    val title: String,
    val episode_id: Int,
    val opening_crawl: String,
    val director: String,
    val producer: String,
    val release_date: String,
    val characters: List<String>
)

data class FilmsResponse(
    val count: Int,
    val results: List<Film>
)