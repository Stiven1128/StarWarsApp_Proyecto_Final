package com.example.starwarsapp_proyecto_final.data.model

data class Person(
    val name: String,
    val height: String,
    val mass: String,
    val gender: String,
    val birth_year: String,
    val homeworld: String,
    val films: List<String>
)