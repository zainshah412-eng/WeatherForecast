package com.example.weather.core.ui.prespentation_layer

import com.example.weather.core.ui.data_layer.model.WeatherResponse
import com.example.weather.core.ui.domain_layer.model.Weather

data class WeatherState(
    val isLoading:Boolean=false,
    val error:String="",
    val data:WeatherResponse?=null
)
