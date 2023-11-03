package com.yash.android.pokemoncards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yash.android.pokemoncards.databinding.FragmentPokemonDetailBinding

class PokemonDetailFragment: Fragment() {
    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
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
        updateUi()
    }

    private fun updateUi() {
        binding.apply {
            pokemonHeight.statName.text = "Height(meter)"
            pokemonHeight.statValue.text = "0.4m"
            pokemonWeight.statName.text = "Weight(Kg)"
            pokemonWeight.statValue.text = "6kg"
            baseStatHp.statName.text = "Hp"
            baseStatHp.statValue.text = "35"
            baseStatAttack.statName.text = "Attack"
            baseStatAttack.statValue.text = "55"
            baseStatDefense.statName.text = "Defense"
            baseStatDefense.statValue.text = "40"
            baseStatSplAttack.statName.text = "Special Attack"
            baseStatSplAttack.statValue.text = "50"
            baseStatSplDefense.statName.text = "Special Defense"
            baseStatSplDefense.statValue.text = "50"
            baseStatSpeed.statName.text = "Speed"
            baseStatSpeed.statValue.text = "90"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}