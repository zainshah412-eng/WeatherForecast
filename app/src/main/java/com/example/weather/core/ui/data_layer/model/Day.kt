package com.example.weather.core.ui.data_layer.model


import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("avghumidity")
    var avghumidity: Double?,
    @SerializedName("avgtemp_c")
    var avgtempC: Double?,
    @SerializedName("avgtemp_f")
    var avgtempF: Double?,
    @SerializedName("avgvis_km")
    var avgvisKm: Double?,
    @SerializedName("avgvis_miles")
    var avgvisMiles: Double?,
    @SerializedName("condition")
    var condition: Condition?,
    @SerializedName("daily_chance_of_rain")
    var dailyChanceOfRain: Double?,
    @SerializedName("daily_chance_of_snow")
    var dailyChanceOfSnow: Double?,
    @SerializedName("daily_will_it_rain")
    var dailyWillItRain: Double?,
    @SerializedName("daily_will_it_snow")
    var dailyWillItSnow: Double?,
    @SerializedName("maxtemp_c")
    var maxtempC: Double?,
    @SerializedName("maxtemp_f")
    var maxtempF: Double?,
    @SerializedName("maxwind_kph")
    var maxwindKph: Double?,
    @SerializedName("maxwind_mph")
    var maxwindMph: Double?,
    @SerializedName("mintemp_c")
    var mintempC: Double?,
    @SerializedName("mintemp_f")
    var mintempF: Double?,
    @SerializedName("totalprecip_in")
    var totalprecipIn: Double?,
    @SerializedName("totalprecip_mm")
    var totalprecipMm: Double?,
    @SerializedName("totalsnow_cm")
    var totalsnowCm: Double?,
    @SerializedName("uv")
    var uv: Double?
)