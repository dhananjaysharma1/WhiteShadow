package com.scale.whiteshadow.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.R.drawable.ic_search_black_24
import com.scale.whiteshadow.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexSearchScreen() {
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
                contentDescription = "Pokeball icon"
            )
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "Pokedex",
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
                    .height(50.dp),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = ic_search_black_24),
                        contentDescription = ""
                    )
                },
                placeholder = { Text(text = "Search", color = Color.Gray, fontSize = 14.sp) },
                shape = RoundedCornerShape(24.dp),
                value = textInput, onValueChange = { textInput = it },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                )
            )

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color = Color.White, shape = CircleShape)
            ) {
                Text(modifier = Modifier.align(Alignment.Center), text = "#", color = Color.Red)
            }
        }

    }
}

@Composable
@Preview(name = "PokedexSearchScreenPreview")
private fun PokedexSearchScreenPreview() {
    PokedexSearchScreen()
}