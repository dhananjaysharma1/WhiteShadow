package com.scale.whiteshadow.View.ui.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.scale.whiteshadow.data.model.PokemonInfo
import java.util.Locale

@Composable
fun PokemonGrid(
    modifier: Modifier = Modifier,
    pokemonList: List<PokemonInfo>,
    searchText: String,
    onClick: (content: PokemonInfo) -> Unit
) {
    val filteredList: List<PokemonInfo> = filteredListItems(searchText, pokemonList)

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = 104.dp),
        content = {
            items(filteredList.size) {
                PokemonTile(
                    id = filteredList[it].id,
                    name = filteredList[it].name,
                    imageUrl = filteredList[it].sprites.other.dreamWorld.frontDefault
                ) { onClick(filteredList[it]) }
            }
        }
    )
}

private fun filteredListItems(
    searchText: String,
    pokemonList: List<PokemonInfo>
): List<PokemonInfo> {
    val filteredList: List<PokemonInfo> = if (searchText.isEmpty()) {
        pokemonList
    } else {
        val resultList = mutableListOf<PokemonInfo>()
        for (item in pokemonList) {
            if (item.name.lowercase(Locale.getDefault())
                .contains(searchText.lowercase(Locale.getDefault())) ||
                (
                    item.id.toString().lowercase(Locale.getDefault())
                        .contains(searchText.lowercase(Locale.getDefault()))
                    )
            ) {
                resultList.add(item)
            }
        }
        resultList
    }
    return filteredList
}
