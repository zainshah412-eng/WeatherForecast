package com.example.weather.core.ui.data_layer.model


import com.google.gson.annotations.SerializedName

data class Condition(
    @SerializedName("code")
    var code: Int?,
    @SerializedName("icon")
    var icon: String?,
    @SerializedName("text")
    var text: String?
)