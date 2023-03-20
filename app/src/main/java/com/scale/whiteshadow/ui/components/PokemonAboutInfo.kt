package com.scale.whiteshadow.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scale.whiteshadow.R
import com.scale.whiteshadow.model.PokemonInfo
import java.util.Locale

@Composable
fun PokemonAboutInfo(modifier: Modifier = Modifier, content: PokemonInfo) {
    val list: MutableList<String> = mutableListOf()
    content.abilities.forEach {
        list.add(it.ability.name)
    }

    Row(
        modifier = modifier
            .wrapContentSize()
            .background(Color.White)
    ) {
        Section(
            painterResource(id = R.drawable.ic_weight),
            content = content.weight,
            footer = "Weight"
        )
        Divider(
            modifier = Modifier
                .height(60.dp)
                .width(1.dp), color = Color.LightGray
        )
        Section(
            painterResource(id = R.drawable.ic_height),
            content = content.height,
            footer = "Height"
        )
        Divider(
            modifier = Modifier
                .height(60.dp)
                .width(1.dp), color = Color.LightGray
        )
        Section(moveList = list, footer = "Moves")
    }
}

@Composable
fun Section(
    image: Painter? = null,
    moveList: List<String>? = null,
    content: Int? = null,
    footer: String
) {
    Column(
        modifier = Modifier.width(120.dp).padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier, horizontalArrangement = Arrangement.Center) {
            if (image != null) {
                Image(
                    painter = image,
                    contentDescription = "",
                    Modifier
                        .padding(end = 8.dp)
                        .size(16.dp)
                )
            }
            if (moveList != null) {
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                    moveList.take(2).forEach { move ->
                        Text(
                            text = move.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                            fontSize = 12.sp
                        )
                    }
                }
            } else {
                Text(text = content.toString(), fontSize = 12.sp)
            }
        }
        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = footer,
            fontSize = 8.sp,
            color = Color.Gray
        )
    }
}