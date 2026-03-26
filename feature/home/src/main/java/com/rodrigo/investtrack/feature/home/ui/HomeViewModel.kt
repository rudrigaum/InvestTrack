package com.rodrigo.investtrack.feature.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigo.investtrack.core.network.model.NetworkResult
import com.rodrigo.investtrack.feature.home.domain.usecase.GetFeaturedQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val getFeaturedQuotesUseCase: GetFeaturedQuotesUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow(HomeUiState())
        val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

        init {
            loadFeaturedQuotes()
        }

        fun loadFeaturedQuotes() {
            getFeaturedQuotesUseCase()
                .onEach { result ->
                    when (result) {
                        is NetworkResult.Loading -> {
                            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
                        }
                        is NetworkResult.Success -> {
                            _uiState.update {
                                it.copy(
                                    isLoading = false,
                                    quotes = result.data,
                                    errorMessage = null,
                                )
                            }
                        }
                        is NetworkResult.Error -> {
                            _uiState.update {
                                it.copy(
                                    isLoading = false,
                                    errorMessage = result.message ?: "An unexpected error occurred.",
                                )
                            }
                        }
                    }
                }.launchIn(viewModelScope)
        }
    }
