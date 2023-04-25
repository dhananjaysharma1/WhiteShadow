package com.scale.whiteshadow.data

import com.scale.whiteshadow.data.PokemonRepository.GetPokemonResponse
import com.scale.whiteshadow.data.model.PokemonInfo
import java.lang.Exception

class WhiteShadowPokemonRepository(
    private val apiService: PokemonApiService
) : PokemonRepository {
    override suspend fun getPokemons(limit: Int, offset: Int): GetPokemonResponse {
        return try {
            val data = apiService.getPokedexList(offset = offset).body()
            if (data != null) {
                GetPokemonResponse.Success(data)
            } else {
                GetPokemonResponse.Error()
            }
        } catch (e: Exception) {
            GetPokemonResponse.Error(e.message.toString())
        }
    }

    override suspend fun getPokemonInfo(name: String): GetPokemonResponse {
        return try {
            val data = apiService.getPokemonInfo(name = name).body()
            if (data != null) {
                GetPokemonResponse.SuccessInfo(data)
            } else {
                GetPokemonResponse.Error()
            }
        } catch (e: Exception) {
            GetPokemonResponse.Error(e.message.toString())
        }
    }

    override suspend fun fetchURL(url: String?): GetPokemonResponse {
        return try {
            val data = apiService.getNextPokemonInfo(url = url).body()
            if (data is PokemonInfo) {
                GetPokemonResponse.SuccessInfo(data)
            } else {
                GetPokemonResponse.Error()
            }
        } catch (e: Exception) {
            GetPokemonResponse.Error(e.message.toString())
        }
    }
}
