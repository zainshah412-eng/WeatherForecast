package com.example.weather.network.remote

import com.example.weather.core.ui.data_layer.model.WeatherResponse
import com.example.weather.utils.AppConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    //https://api.weatherapi.com/v1/forecast.json?q=gujranwala&days=5&key=c44359520b184dfb9f574842242009

    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("q") city: String,
        @Query("days") days: Int = 5,
        @Query("key") apiKey: String = "c44359520b184dfb9f574842242009"
    ): WeatherResponse

}