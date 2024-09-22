package com.example.weather.core.ui.data_layer.model


import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("current")
    var currentDTO: CurrentDTO?,
    @SerializedName("forecast")
    var forecastDTO: ForecastDTO?,
    @SerializedName("location")
    var locationDTO: LocationDTO?
)