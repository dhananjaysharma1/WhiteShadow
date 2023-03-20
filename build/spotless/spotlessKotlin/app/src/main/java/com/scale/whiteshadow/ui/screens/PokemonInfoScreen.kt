package com.scale.whiteshadow.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.scale.whiteshadow.R
import com.scale.whiteshadow.model.PokemonInfo
import com.scale.whiteshadow.ui.components.PokemonAboutInfo
import com.scale.whiteshadow.ui.components.PokemonStatsInfo
import java.util.Locale

@Composable
fun PokemonInfoScreen(content: PokemonInfo, onBackPressed: () -> Unit) {
    Column(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxSize()
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .size(40.dp)
                        .clickable { onBackPressed() },
                    painter = painterResource(id = R.drawable.ic_arrow_white),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 30.sp,
                    text = content.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    fontSize = 24.sp,
                    text = stringResource(id = R.string.pokemon_id, content.id),
                    color = Color.White
                )
            }
        }
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(content.sprites.other.dreamWorld.frontDefault)
                .decoderFactory(SvgDecoder.Factory())
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_pokeball),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally),
            fallback = painterResource(R.drawable.ic_pokeball)
        )

        Column(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .fillMaxHeight()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = stringResource(id = R.string.about),
                fontSize = 14.sp,
                fontWeight = FontWeight.Black
            )
            PokemonAboutInfo(modifier = Modifier.padding(top = 16.dp), content = content)
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = stringResource(id = R.string.base_stats),
                fontSize = 14.sp,
                fontWeight = FontWeight.Black
            )
            PokemonStatsInfo(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 16.dp),
                content = content
            )
        }
    }
}
