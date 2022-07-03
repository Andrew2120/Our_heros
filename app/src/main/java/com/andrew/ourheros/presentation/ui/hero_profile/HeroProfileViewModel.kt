package com.andrew.ourheros.presentation.ui.hero_profile

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrew.ourheros.comman.Constants.PARAM_HERO
import com.andrew.ourheros.comman.Resource
import com.andrew.ourheros.domain.use_case.get_hero.GetHeroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HeroProfileViewModel @Inject constructor(
    private val getHeroesUseCase: GetHeroUseCase,
    handle: SavedStateHandle,
) : ViewModel() {


    private val _state = mutableStateOf(HeroProfileState())
    val state: State<HeroProfileState> = _state

    init {
        handle.get<String>(PARAM_HERO)?.let { heroId ->
                Log.d("TAG", ": XXXXXX" +heroId)
            getHero(heroId)
        }
    }

    private fun getHero(coinId: String) {
        getHeroesUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = HeroProfileState(hero = result.data)
                }
                is Resource.Error -> {
                    _state.value = HeroProfileState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = HeroProfileState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}