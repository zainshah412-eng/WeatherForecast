package com.example.weather.core.ui.domain_layer.model

import androidx.room.Entity
import com.example.weather.core.ui.data_layer.model.CurrentDTO
import com.example.weather.core.ui.data_layer.model.ForecastDTO
import com.example.weather.core.ui.data_layer.model.LocationDTO
import com.google.gson.annotations.SerializedName

data class Weather(
    var currentDTO: Current?,
    var forecastDTO: List<Forecast?>,
    var locationDTO: Location?
)
