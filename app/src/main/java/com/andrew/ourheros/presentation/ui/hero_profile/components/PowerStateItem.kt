package com.andrew.ourheros.presentation.ui.hero_profile.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun PowerState(title: Int, value: String) {

    Row {
        Text(
            text = stringResource(id = title)+":",
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = value,
            overflow = TextOverflow.Ellipsis
        )
    }
}
