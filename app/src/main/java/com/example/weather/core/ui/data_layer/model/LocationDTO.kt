package com.example.weather.core.ui.data_layer.model


import com.google.gson.annotations.SerializedName

data class LocationDTO(
    @SerializedName("country")
    var country: String?,
    @SerializedName("lat")
    var lat: Double?,
    @SerializedName("localtime")
    var localtime: String?,
    @SerializedName("localtime_epoch")
    var localtimeEpoch: Int?,
    @SerializedName("lon")
    var lon: Double?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("region")
    var region: String?,
    @SerializedName("tz_id")
    var tzId: String?
)