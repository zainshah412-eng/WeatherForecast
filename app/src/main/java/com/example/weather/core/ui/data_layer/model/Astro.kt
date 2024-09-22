package com.example.weather.core.ui.data_layer.model


import com.google.gson.annotations.SerializedName

data class Astro(
    @SerializedName("is_moon_up")
    var isMoonUp: Double?,
    @SerializedName("is_sun_up")
    var isSunUp: Double?,
    @SerializedName("moon_illumination")
    var moonIllumination: Double?,
    @SerializedName("moon_phase")
    var moonPhase: String?,
    @SerializedName("moonrise")
    var moonrise: String?,
    @SerializedName("moonset")
    var moonset: String?,
    @SerializedName("sunrise")
    var sunrise: String?,
    @SerializedName("sunset")
    var sunset: String?
)