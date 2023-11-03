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
        binding.pokeHeight.statName.text = "Height"
        binding.pokeHeight.statValue.text = ".1m"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}