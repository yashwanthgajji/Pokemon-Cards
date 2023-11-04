package com.yash.android.pokemoncards.models

import java.util.UUID

data class Pokemon(
    val id: UUID,
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