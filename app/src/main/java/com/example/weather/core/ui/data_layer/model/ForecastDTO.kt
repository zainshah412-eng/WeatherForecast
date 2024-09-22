package com.example.weather.core.ui.data_layer.model


import com.google.gson.annotations.SerializedName

data class ForecastDTO(
    @SerializedName("forecastday")
    var forecastday: List<Forecastday>?
)