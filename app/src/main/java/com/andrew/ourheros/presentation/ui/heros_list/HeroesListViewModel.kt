package com.andrew.ourheros.presentation.ui.heros_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrew.ourheros.comman.Resource
import com.andrew.ourheros.domain.use_case.get_heros.GetHeroesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HeroesListViewModel @Inject constructor(
    private val getHeroesUseCase: GetHeroesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(HeroesListState())
    val state: State<HeroesListState> = _state

    init {
        getHeroes()
    }

    private fun getHeroes() {
        getHeroesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = HeroesListState(heroes = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = HeroesListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = HeroesListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}