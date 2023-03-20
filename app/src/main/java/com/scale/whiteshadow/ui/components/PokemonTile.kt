package com.scale.whiteshadow.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.scale.whiteshadow.R
import java.util.Locale

@Composable
fun PokemonTile(id: Int, name: String, imageUrl: String?, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(2.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(6.dp))
            .background(Color.White, shape = RoundedCornerShape(6.dp))
            .clickable { onClick() }
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 8.dp, top = 4.dp),
            text = stringResource(id = R.string.pokemon_id, id),
            fontSize = 10.sp
        )
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .decoderFactory(SvgDecoder.Factory())
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_pokeball),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(72.dp)
                .align(Alignment.Center),
            fallback = painterResource(R.drawable.ic_pokeball)
        )
        Text(
            modifier = Modifier
                .padding(bottom = 4.dp)
                .align(Alignment.BottomCenter),
            text = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
            fontSize = 14.sp
        )
    }
}

@Composable
@Preview(name = "PokemonTilePreview")
private fun PokemonTilePreview() {
    PokemonTile(id = 999, name = "Bulbasaur", imageUrl = "") { }
}