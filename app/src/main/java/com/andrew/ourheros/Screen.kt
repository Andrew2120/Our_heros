package com.andrew.ourheros

sealed class Screen(val route: String) {
    object HeroesListScreen : Screen("heroes_list_screen")
    object HeroProfileScreen : Screen("hero_profile_screen")
}