package com.scale.whiteshadow.data

import com.scale.whiteshadow.data.PokemonRepository.GetPokemonResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class WhiteShadowRepositoryTest {
    private val apiService = MockPokemonApiService()
    private val repo = WhiteShadowPokemonRepository(apiService = apiService)

    @Test
    fun shouldReturnError_whenGetPokemonsFails() = runTest {
        apiService.whenGetPokemonListResponseFails()

        assertTrue(repo.getPokemons(limit = 20, offset = 0) is GetPokemonResponse.Error)
    }

    @Test
    fun shouldReturnError_whenGetPokemonInfoFails() = runTest {
        apiService.whenGetPokemonInfoResponseFails()

        assertTrue(repo.getPokemonInfo(name = "Pika") is GetPokemonResponse.Error)
    }

    @Test
    fun shouldReturnError_whenFetchUrlFails() = runTest {
        apiService.whenNextPokemonInfoResponseFails()

        assertTrue(repo.fetchURL(url = "https://pokemon.com") is GetPokemonResponse.Error)
    }
}