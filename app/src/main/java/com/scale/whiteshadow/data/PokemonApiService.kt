package com.scale.whiteshadow.data

import com.scale.whiteshadow.data.model.PokemonInfo
import com.scale.whiteshadow.data.model.Pokemons
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokemonApiService {
    @GET("/api/v2/pokemon")
    suspend fun getPokedexList(
        @Query("limit") limit: Int = 650,
        @Query("offset") offset: Int,
    ): Response<Pokemons>

    @GET("/api/v2/pokemon/{name}")
    suspend fun getPokemonInfo(@Path("name") name: String): Response<PokemonInfo>

    @GET
    suspend fun getNextPokemonInfo(@Url url: String?): Response<PokemonInfo>

    companion object {
        fun create(retrofit: Retrofit) = retrofit.create<PokemonApiService>()
    }
}
