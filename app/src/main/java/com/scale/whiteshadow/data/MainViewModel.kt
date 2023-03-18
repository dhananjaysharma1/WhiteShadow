package com.scale.whiteshadow.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scale.whiteshadow.data.PokemonRepository.GetPokemonResponse
import com.scale.whiteshadow.model.PokemonInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class MainViewModel(
    private val pokemonRepo: PokemonRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _pokemonData = MutableLiveData<PokemonInfo>()
    val pokemonData: LiveData<PokemonInfo> = _pokemonData

    init {
        viewModelScope.launch(ioDispatcher) {
            val whiteShadowResponse = pokemonRepo.getPokemons()
            if (whiteShadowResponse is GetPokemonResponse.SuccessInfo) {
                _pokemonData.postValue(whiteShadowResponse.content)
            }
        }
    }

    private fun getPokemonInfo() {
        viewModelScope.launch(ioDispatcher) {
            val whiteShadowResponse = pokemonRepo.getPokemonInfo()
            if (whiteShadowResponse is GetPokemonResponse.SuccessInfo) {
                _pokemonData.postValue(whiteShadowResponse.content)
            }
        }
    }
}