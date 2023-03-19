package com.scale.whiteshadow.ui.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.scale.whiteshadow.model.PokemonInfo

@Composable
fun PokemonGrid(modifier: Modifier = Modifier, pokemonList: List<PokemonInfo>) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = 104.dp),
        content = {
            items(pokemonList.size) {
                PokemonTile(
                    id = pokemonList[it].id,
                    name = pokemonList[it].name,
                    imageUrl = pokemonList[it].sprites.other.dreamWorld.frontDefault
                )
            }
        })
}

@Composable
@Preview(name = "PokemonGridPreview")
private fun PokemonGridPreview() {
//    PokemonGrid(pokemonList = listOf(Test(), Test(), Test(), Test()))
}

data class Test(
    val id: Int = 1123,
    val name: String = "Dhan"
)