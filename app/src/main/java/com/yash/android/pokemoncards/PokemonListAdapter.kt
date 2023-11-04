package com.yash.android.pokemoncards

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yash.android.pokemoncards.databinding.PokemonListItemBinding
import com.yash.android.pokemoncards.models.Pokemon

class PokemonListCardHolder(private val binding: PokemonListItemBinding, private val context: Context): RecyclerView.ViewHolder(binding.root) {
    fun bind(pokemon: Pokemon) {
        val logoResourceId = context.resources.getIdentifier(pokemon.imageFile.split(".")[0], "drawable", context.packageName)
        binding.apply {
            pokemonListImage.setImageResource(logoResourceId)
            pokemonListName.text = pokemon.name
        }
    }
}

class PokemonListAdapter(private val pokemons: List<Pokemon>):
    RecyclerView.Adapter<PokemonListCardHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListCardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PokemonListItemBinding.inflate(inflater)
        return PokemonListCardHolder(binding, parent.context)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: PokemonListCardHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bind(pokemon)
    }

}