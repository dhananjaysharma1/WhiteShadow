package com.scale.whiteshadow.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scale.whiteshadow.data.PokemonRepository.GetPokemonResponse
import com.scale.whiteshadow.model.PokemonInfo
import com.scale.whiteshadow.model.Pokemons
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class MainViewModel(
    private val pokemonRepo: PokemonRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private var infoList: MutableList<PokemonInfo> = mutableListOf()

    private val _pokemonList = MutableLiveData<Pokemons>()
    val pokemonList: LiveData<Pokemons> = _pokemonList

    private val _pokemonInfoList = MutableLiveData<List<PokemonInfo>>()
    val pokemonInfoList: LiveData<List<PokemonInfo>> = _pokemonInfoList

    val selectedPokemon = MutableLiveData<PokemonInfo>()

    init {
        if (_pokemonInfoList.value.isNullOrEmpty()) {
            fetchPokeDex()
        }
    }

    private fun fetchPokeDex() {
        viewModelScope.launch(ioDispatcher) {
            val response = pokemonRepo.getPokemons(limit = 40, offset = 0)
            if (response is GetPokemonResponse.Success) {
                _pokemonList.postValue(response.content)
                response.content.results.forEach {
                    val infoResponse = pokemonRepo.fetchURL(it.url)
                    if (infoResponse is GetPokemonResponse.SuccessInfo) {
                        infoList.add(infoResponse.pokemonInfo)
                        _pokemonInfoList.postValue(infoList)
                    }
                }
            }
        }
    }
}