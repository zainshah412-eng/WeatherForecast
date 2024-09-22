package com.example.weather.core.ui.domain_layer.repository

import com.example.weather.core.ui.data_layer.model.WeatherResponse
import com.example.weather.core.ui.domain_layer.model.Current
import com.example.weather.core.ui.domain_layer.model.Weather


interface WeatherRepository {
    suspend fun getWeather(city: String): WeatherResponse
}