package com.scale.whiteshadow.data

import com.scale.whiteshadow.data.model.PokemonInfo
import com.scale.whiteshadow.data.model.Pokemons

interface PokemonRepository {
    sealed class GetPokemonResponse {

        class Success(val content: Pokemons) : GetPokemonResponse()

        class SuccessInfo(val pokemonInfo: PokemonInfo) : GetPokemonResponse()

        class Error(val message: String = "Something went wrong.") : GetPokemonResponse()
    }

    suspend fun getPokemons(limit: Int, offset: Int): GetPokemonResponse

    suspend fun getPokemonInfo(name: String): GetPokemonResponse

    suspend fun fetchURL(url: String): GetPokemonResponse
}
