package com.andrew.ourheros.presentation.ui.hero_profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.andrew.ourheros.R
import com.andrew.ourheros.presentation.ui.hero_profile.components.PowerState

@Composable
fun HeroProfileScreen(
    viewModel: HeroProfileViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {


        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if (state.hero!=null){
            LazyColumn(modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()) {
                item {
                    Box(
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp)
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(state.hero.images.lg)
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.clip(CircleShape)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    state.hero.name.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.h5,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Divider()
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(id = R.string.general_information),
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row {
                        Text(
                            text = stringResource(id = R.string.gender),
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        state.hero.appearance?.gender?.let {
                            Text(
                                text = it,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                    Row {
                        Text(
                            text = stringResource(id = R.string.height),
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        state.hero.appearance?.height?.first()?.let {
                            Text(
                                text = it,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                    Row {
                        Text(
                            text = stringResource(id = R.string.weight),
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        state.hero.appearance?.weight?.first()?.let {
                            Text(
                                text = it,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Divider()
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(id = R.string.powerstats),
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis
                    )

                    PowerState(R.string.intelligence, state.hero.powerstats?.intelligence.toString())
                    PowerState(R.string.strength, state.hero.powerstats?.strength.toString())
                    PowerState(R.string.speed, state.hero.powerstats?.speed.toString())
                    PowerState(R.string.durability, state.hero.powerstats?.durability.toString())
                    PowerState(R.string.power, state.hero.powerstats?.power.toString())
                    PowerState(R.string.combat, state.hero.powerstats?.combat.toString())


                }
            }
        }
    }
}