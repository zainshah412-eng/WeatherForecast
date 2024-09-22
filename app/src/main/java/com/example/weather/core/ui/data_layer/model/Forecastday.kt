package com.example.weather.core.ui.data_layer.model


import com.google.gson.annotations.SerializedName

data class Forecastday(
    @SerializedName("astro")
    var astro: Astro?,
    @SerializedName("date")
    var date: String?,
    @SerializedName("date_epoch")
    var dateEpoch: Double?,
    @SerializedName("day")
    var day: Day?,
    @SerializedName("hour")
    var hour: List<Hour>?
)