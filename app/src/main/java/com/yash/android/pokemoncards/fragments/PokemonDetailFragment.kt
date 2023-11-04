package com.yash.android.pokemoncards.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.yash.android.pokemoncards.databinding.FragmentPokemonDetailBinding
import com.yash.android.pokemoncards.models.Pokemon
import com.yash.android.pokemoncards.viewmodels.PokemonDetailViewModel
import com.yash.android.pokemoncards.viewmodels.PokemonDetailViewModelFactory
import kotlinx.coroutines.launch

class PokemonDetailFragment: Fragment() {
    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }
    private val args:PokemonDetailFragmentArgs by navArgs()
    private val pokemonDetailViewModel: PokemonDetailViewModel by viewModels() {
        PokemonDetailViewModelFactory(args.pokemonId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            pokemonHeight.statName.text = "Height(meter)"
            pokemonWeight.statName.text = "Weight(Kg)"
            baseStatHp.statName.text = "Hp"
            baseStatAttack.statName.text = "Attack"
            baseStatDefense.statName.text = "Defense"
            baseStatSplAttack.statName.text = "Special Attack"
            baseStatSplDefense.statName.text = "Special Defense"
            baseStatSpeed.statName.text = "Speed"
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                pokemonDetailViewModel.pokemonFlow.collect { pokemon ->
                    pokemon?.let { updateUi(it) }
                }
            }
        }
    }

    private fun updateUi(pokemon: Pokemon) {
        val logoResourceId = context?.resources?.getIdentifier(
            pokemon.imageFile.split(".")[0],
            "drawable",
            requireContext().packageName
        )
        binding.apply {
            logoResourceId?.let { pokemonImage.setImageResource(it) }
            pokemonName.text = pokemon.name
            pokemonHeight.statValue.text = pokemon.height.toString()
            pokemonWeight.statValue.text = pokemon.weight.toString()
            baseStatHp.statValue.text = pokemon.hp.toString()
            baseStatAttack.statValue.text = pokemon.attack.toString()
            baseStatDefense.statValue.text = pokemon.defense.toString()
            baseStatSplAttack.statValue.text = pokemon.specialAttack.toString()
            baseStatSplDefense.statValue.text = pokemon.specialDefense.toString()
            baseStatSpeed.statValue.text = pokemon.speed.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}