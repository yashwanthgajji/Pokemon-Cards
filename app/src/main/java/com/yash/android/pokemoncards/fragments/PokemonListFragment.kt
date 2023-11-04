package com.yash.android.pokemoncards.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.yash.android.pokemoncards.PokemonListAdapter
import com.yash.android.pokemoncards.databinding.FragmentPokemonListBinding
import com.yash.android.pokemoncards.viewmodels.PokemonListViewModel

class PokemonListFragment: Fragment() {
    private val pokemonListViewModel: PokemonListViewModel by viewModels()
    private var _binding: FragmentPokemonListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokemonListBinding.inflate(layoutInflater, container, false)
        binding.pokemonRecyclerView.layoutManager = GridLayoutManager(context, 3)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pokemonRecyclerView.adapter = PokemonListAdapter(pokemonListViewModel.pokemons)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}