package com.scale.whiteshadow.data

import com.scale.whiteshadow.model.PokemonInfo
import com.scale.whiteshadow.model.Pokemons

interface PokemonRepository {
    sealed class GetPokemonResponse {

        class Success(val content: Pokemons) : GetPokemonResponse()

        class SuccessInfo(val content: PokemonInfo) : GetPokemonResponse()

        class Error(val message: String = "Something went wrong.") : GetPokemonResponse()
    }

    suspend fun getPokemons(): GetPokemonResponse

    suspend fun getPokemonInfo(name: String): GetPokemonResponse
}