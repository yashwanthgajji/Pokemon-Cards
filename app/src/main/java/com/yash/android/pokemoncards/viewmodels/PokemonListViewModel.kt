package com.yash.android.pokemoncards.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yash.android.pokemoncards.PokemonRepository
import com.yash.android.pokemoncards.models.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonListViewModel: ViewModel() {
    private val pokemonRepository = PokemonRepository.getInstance()
    private val _pokemonsFlow: MutableStateFlow<List<Pokemon>> = MutableStateFlow(emptyList())
    val pokemonsFlow: StateFlow<List<Pokemon>>
        get() = _pokemonsFlow.asStateFlow()

    init {
        viewModelScope.launch {
            pokemonRepository.getAllPokemons().collect {
                _pokemonsFlow.value = it
            }
        }
    }
}