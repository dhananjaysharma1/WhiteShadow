package com.scale.whiteshadow.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scale.whiteshadow.R

@Composable
fun PokemonTile() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(2.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(6.dp))
            .background(Color.Green, shape = RoundedCornerShape(6.dp))
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 8.dp, top = 4.dp),
            text = "#999",
            fontSize = 8.sp
        )
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.ic_pokeball),
            contentDescription = ""
        )
        Text(
            modifier = Modifier
                .padding(bottom = 4.dp)
                .align(Alignment.BottomCenter),
            text = "Bulbasaur",
            fontSize = 10.sp
        )
    }
}

@Composable
@Preview(name = "PokemonTilePreview")
private fun PokemonTilePreview() {
    PokemonTile()
}