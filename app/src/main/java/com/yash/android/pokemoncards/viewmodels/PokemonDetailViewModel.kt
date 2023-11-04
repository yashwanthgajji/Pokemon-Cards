package com.yash.android.pokemoncards.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.yash.android.pokemoncards.PokemonRepository
import com.yash.android.pokemoncards.models.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class PokemonDetailViewModel(pokemonId: UUID): ViewModel() {
    private val pokemonRepository = PokemonRepository.getInstance()
    private val _pokemonFlow: MutableStateFlow<Pokemon?> = MutableStateFlow(null)
    val pokemonFlow: StateFlow<Pokemon?>
        get() = _pokemonFlow.asStateFlow()

    init {
        viewModelScope.launch {
            pokemonRepository.getPokemonById(pokemonId).collect {
                _pokemonFlow.value = it
            }
        }
    }

}

class PokemonDetailViewModelFactory(private val pokemonId: UUID): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonDetailViewModel(pokemonId) as T
    }
}