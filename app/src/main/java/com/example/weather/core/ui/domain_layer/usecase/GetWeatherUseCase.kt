package com.example.weather.core.ui.domain_layer.usecase

import com.example.weather.core.ui.data_layer.model.WeatherResponse
import com.example.weather.core.ui.domain_layer.model.Weather
import com.example.weather.core.ui.domain_layer.repository.WeatherRepository
import com.example.weather.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetWeatherUseCase @Inject constructor(private val listingRepository: WeatherRepository) {
    operator fun invoke(city: String): kotlinx.coroutines.flow.Flow<Resource<WeatherResponse>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = listingRepository.getWeather(city)))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}