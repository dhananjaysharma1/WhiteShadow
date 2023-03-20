package com.scale.whiteshadow.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.R.drawable.ic_search_black_24
import com.scale.whiteshadow.R
import com.scale.whiteshadow.data.MainViewModel
import com.scale.whiteshadow.model.PokemonInfo
import com.scale.whiteshadow.ui.components.PokemonGrid

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexSearchScreenContent(
    mainViewModel: MainViewModel,
    onClick: (pokemonInfo: PokemonInfo) -> Unit
) {
    val infoList by mainViewModel.pokemonInfoList.observeAsState()

    var textInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.Red)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(28.dp),
                painter = painterResource(id = R.drawable.ic_pokeball),
                contentDescription = stringResource(R.string.header_icon_desc)
            )
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = stringResource(id = R.string.pokedex),
                fontSize = 24.sp,
                color = Color.White,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Black
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = ic_search_black_24),
                        contentDescription = ""
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.search_placeholder),
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                },
                shape = RoundedCornerShape(24.dp),
                value = textInput,
                onValueChange = { textInput = it },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                )
            )
        }
        if (infoList != null) {
            PokemonGrid(
                modifier = Modifier.padding(top = 24.dp),
                pokemonList = infoList!!,
                searchText = textInput,
                onClick = { content ->
                    onClick(content)
                })
        }
    }
}