package com.yash.android.pokemoncards

import android.content.Context
import com.yash.android.pokemoncards.models.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.util.UUID

class PokemonRepository private constructor(context: Context) {
    private var pokemons = mutableListOf<Pokemon>()

    init {
        pokemons = mutableListOf(
            Pokemon(
                UUID.randomUUID(),
                "Bulbasaur",
                "bulbasaur.png",
                0.7,
                6.9,
                45,
                49,
                49,
                65,
                65,
                45
            ),
            Pokemon(
                UUID.randomUUID(),
                "Arbok",
                "arbok.png",
                3.5,
                65.0,
                60,
                95,
                69,
                65,
                79,
                80
            ),
            Pokemon(
                UUID.randomUUID(),
                "Charmander",
                "charmander.png",
                0.6,
                8.5,
                39,
                52,
                43,
                60,
                50,
                65
            ),
            Pokemon(
                UUID.randomUUID(),
                "Mewtwo",
                "mewtwo.png",
                2.0,
                122.0,
                106,
                110,
                90,
                154,
                90,
                130
            ),
            Pokemon(
                UUID.randomUUID(),
                "Moltres",
                "moltres.png",
                2.0,
                60.0,
                90,
                100,
                90,
                125,
                85,
                90
            ),
            Pokemon(
                UUID.randomUUID(),
                "Onix",
                "onix.png",
                8.8,
                210.0,
                35,
                45,
                160,
                30,
                45,
                70
            ),
            Pokemon(
                UUID.randomUUID(),
                "Pikachu",
                "pikachu.png",
                0.4,
                6.0,
                35,
                55,
                40,
                50,
                50,
                90
            ),
            Pokemon(
                UUID.randomUUID(),
                "Treecko",
                "treecko.png",
                0.5,
                5.0,
                40,
                45,
                35,
                65,
                55,
                70
            )
        )
    }

    fun getAllPokemons(): Flow<List<Pokemon>> {
        return flowOf(pokemons)
    }

    fun getPokemonById(pokemonId: UUID): Flow<Pokemon?> {
        return flowOf(pokemons.find { pokemon -> pokemon.id == pokemonId })
    }

    companion object {
        private var INSTANCE: PokemonRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = PokemonRepository(context)
            }
        }

        fun getInstance(): PokemonRepository {
            return INSTANCE ?: throw IllegalStateException("PokemonRepository must be initialized")
        }
    }
}