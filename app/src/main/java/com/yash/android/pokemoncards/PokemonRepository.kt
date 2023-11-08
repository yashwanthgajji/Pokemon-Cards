package com.yash.android.pokemoncards

import android.content.Context
import android.util.Log
import com.yash.android.pokemoncards.models.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.util.UUID

const val TAG = "PokemonRepository"
class PokemonRepository private constructor(private val context: Context) {
    private var pokemons = mutableListOf<Pokemon>()

    init {
        pokemons = readDataSet()
    }

    fun getAllPokemons(): Flow<List<Pokemon>> {
        return flowOf(pokemons)
    }

    fun getPokemonById(pokemonId: UUID): Flow<Pokemon?> {
        return flowOf(pokemons.find { pokemon -> pokemon.id == pokemonId })
    }

    private fun readDataSet(): MutableList<Pokemon> {
        val assetManager = context.assets
        val pokemonList = mutableListOf<Pokemon>()
        try {
            val inputStream = assetManager.open("pokedex.csv")
            inputStream.bufferedReader().useLines { lines ->
                var i = 0
                for (line in lines) {
                    if (i == 0) {
                        i++
                        continue
                    }
                    val values = line.split(",")
                    val logoResourceId = context.resources.getIdentifier(
                        values[2].lowercase(),
                        "drawable",
                        context.packageName
                    )
                    if (logoResourceId != 0) {
                        val currPokemon = Pokemon(
                            UUID.randomUUID(),
                            values[2],
                            values[2].lowercase() + ".png",
                            values[11].toDouble(),
                            values[12].toDouble(),
                            values[18].toDouble().toInt(),
                            values[19].toDouble().toInt(),
                            values[20].toDouble().toInt(),
                            values[21].toDouble().toInt(),
                            values[22].toDouble().toInt(),
                            values[23].toDouble().toInt()
                        )
                        Log.d(TAG, "$currPokemon")
                        pokemonList.add(currPokemon)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return pokemonList
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