package com.andrew.ourheros.presentation.ui.hero_profile

import com.andrew.ourheros.domain.model.HeroDetails


data class HeroProfileState(
    val isLoading: Boolean = false,
    val hero: HeroDetails? = null,
    val error: String = ""
)