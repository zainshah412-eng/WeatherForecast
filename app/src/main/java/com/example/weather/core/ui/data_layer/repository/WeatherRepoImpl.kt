package com.example.weather.core.ui.data_layer.repository
import com.example.weather.core.ui.data_layer.model.WeatherResponse
import com.example.weather.core.ui.domain_layer.repository.WeatherRepository
import com.example.weather.network.remote.WeatherApiService
class WeatherRepoImpl(
    private val weatherApiService: WeatherApiService
) : WeatherRepository {
    override suspend fun getWeather(city: String): WeatherResponse {
        return weatherApiService.getWeatherForecast(city, 5)
    }
}