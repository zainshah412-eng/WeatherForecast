package com.example.weather.core.ui.data_layer.model


import com.google.gson.annotations.SerializedName

data class CurrentDTO(
    @SerializedName("cloud")
    var cloud: Double?,
    @SerializedName("condition")
    var condition: Condition?,
    @SerializedName("dewpoint_c")
    var dewpointC: Double?,
    @SerializedName("dewpoint_f")
    var dewpointF: Double?,
    @SerializedName("feelslike_c")
    var feelslikeC: Double?,
    @SerializedName("feelslike_f")
    var feelslikeF: Double?,
    @SerializedName("gust_kph")
    var gustKph: Double?,
    @SerializedName("gust_mph")
    var gustMph: Double?,
    @SerializedName("heatindex_c")
    var heatindexC: Double?,
    @SerializedName("heatindex_f")
    var heatindexF: Double?,
    @SerializedName("humidity")
    var humidity: Double?,
    @SerializedName("is_day")
    var isDay: Double?,
    @SerializedName("last_updated")
    var lastUpdated: String?,
    @SerializedName("last_updated_epoch")
    var lastUpdatedEpoch: Double?,
    @SerializedName("precip_in")
    var precipIn: Double?,
    @SerializedName("precip_mm")
    var precipMm: Double?,
    @SerializedName("pressure_in")
    var pressureIn: Double?,
    @SerializedName("pressure_mb")
    var pressureMb: Double?,
    @SerializedName("temp_c")
    var tempC: Double?,
    @SerializedName("temp_f")
    var tempF: Double?,
    @SerializedName("uv")
    var uv: Double?,
    @SerializedName("vis_km")
    var visKm: Double?,
    @SerializedName("vis_miles")
    var visMiles: Double?,
    @SerializedName("wind_degree")
    var windDegree: Double?,
    @SerializedName("wind_dir")
    var windDir: String?,
    @SerializedName("wind_kph")
    var windKph: Double?,
    @SerializedName("wind_mph")
    var windMph: Double?,
    @SerializedName("windchill_c")
    var windchillC: Double?,
    @SerializedName("windchill_f")
    var windchillF: Double?
)