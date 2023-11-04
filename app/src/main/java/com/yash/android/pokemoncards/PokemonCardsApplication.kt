package com.yash.android.pokemoncards

import android.app.Application

class PokemonCardsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        PokemonRepository.initialize(this)
    }
}