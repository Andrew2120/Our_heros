package com.andrew.ourheros.presentation.ui.heros_list.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.andrew.ourheros.R
import com.andrew.ourheros.data.remote.dto.Images
import com.andrew.ourheros.domain.model.Hero
import com.andrew.ourheros.presentation.ui.theme.OurHerosTheme

@Composable
fun HeroListItem(
    hero: Hero,
    onItemClick: (Hero) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(hero) }
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .width(65.dp)
                .height(65.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(hero.images.lg)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))



        Text(
            text = hero.name,
            style = MaterialTheme.typography.h6,
            overflow = TextOverflow.Ellipsis
        )

    }
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun SnackCardPreview() {
    OurHerosTheme {
        HeroListItem(
            hero = Hero(
                name = "Andrew",
                images = Images(lg = "", md = "", sm = "", xs = ""),
                id = 1
            ),
            onItemClick = {}

        )
    }
}