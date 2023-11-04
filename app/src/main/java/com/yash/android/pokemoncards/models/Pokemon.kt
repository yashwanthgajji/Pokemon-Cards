package com.yash.android.pokemoncards.models

data class Pokemon(
    val name: String,
    val imageFile: String,
    val height: Double,
    val weight: Double,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val specialAttack: Int,
    val specialDefense: Int,
    val speed: Int
)