package com.example.weather.core.ui.prespentation_layer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.core.ui.domain_layer.usecase.GetWeatherUseCase
import com.example.weather.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val getListingUseCase: GetWeatherUseCase) :
    ViewModel() {
    private val _listing = MutableStateFlow(WeatherState())
    val listing: StateFlow<WeatherState> = _listing


    fun getListing(key: String) {
        getListingUseCase(key).onEach {
            when (it) {
                is Resource.Loading -> {
                    _listing.value = WeatherState(isLoading = true)
                }

                is Resource.Error -> {
                    _listing.value = WeatherState(error = it.message)
                }

                is Resource.Success -> {
                    _listing.value = WeatherState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}