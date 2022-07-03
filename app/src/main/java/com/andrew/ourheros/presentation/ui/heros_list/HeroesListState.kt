package com.andrew.ourheros.presentation.ui.heros_list

import com.andrew.ourheros.domain.model.Hero

data class HeroesListState(
    val isLoading: Boolean = false,
    val heroes: List<Hero> = emptyList(),
    val error: String = ""
)
