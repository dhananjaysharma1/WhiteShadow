package com.scale.whiteshadow.View.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.scale.whiteshadow.data.model.PokemonInfo

@Composable
fun PokemonStatsInfo(modifier: Modifier = Modifier, content: PokemonInfo) {
    Column(modifier = modifier.background(Color.White)) {
        content.stats.forEach {
            StatsItem(it.stat.name, it.baseStat)
        }
    }
}

@Composable
fun StatsItem(statName: String, statValue: Int) {
    Column(modifier = Modifier.padding(vertical = 10.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = statName.uppercase())
            Divider(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .width(1.dp)
            )
            Text(modifier = Modifier.padding(start = 8.dp), text = statValue.toString())
        }
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 4.dp)
                .fillMaxWidth(),
            progress = statValue.toFloat() / 255
        )
    }
}
