package com.scale.whiteshadow.data

import com.scale.whiteshadow.data.model.PokemonInfo
import com.scale.whiteshadow.data.model.Pokemons
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

class MockPokemonApiService: PokemonApiService {
    private var getPokemonListResponse: Response<Pokemons>? = null
    private val getPokemonInfoResponse: Response<PokemonInfo>? = null
    private val getNextPokemonInfoResponse: Response<PokemonInfo>? = null

    override suspend fun getPokedexList(limit: Int, offset: Int): Response<Pokemons> = getPokemonListResponse!!
    override suspend fun getPokemonInfo(name: String): Response<PokemonInfo> = getPokemonInfoResponse!!
    override suspend fun getNextPokemonInfo(url: String): Response<PokemonInfo> = getNextPokemonInfoResponse!!

    fun whenGetPokemonListResponseFails() {
        getPokemonListResponse = Response.error(400, "".toResponseBody())
    }

    fun whenGetPokemonInfoResponseFails() {
        getPokemonListResponse = Response.error(400, "".toResponseBody())
    }

    fun whenNextPokemonInfoResponseFails() {
        getPokemonListResponse = Response.error(400, "".toResponseBody())
    }
}