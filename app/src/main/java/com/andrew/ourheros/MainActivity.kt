package com.andrew.ourheros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andrew.ourheros.presentation.ui.hero_profile.HeroProfileScreen
import com.andrew.ourheros.presentation.ui.heros_list.HeroesListScreen
import com.andrew.ourheros.presentation.ui.theme.OurHerosTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OurHerosTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HeroesListScreen.route
                    ) {
                        composable(
                            route = Screen.HeroesListScreen.route
                        ) {
                            HeroesListScreen(navController)
                        }
                        composable(
                            route = Screen.HeroProfileScreen.route + "/{heroId}"
                        ) {
                            HeroProfileScreen()
                        }
                    }
                }
            }
        }
    }
}