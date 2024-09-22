package com.example.weather.utils.apierror;

import com.google.gson.annotations.SerializedName

data class ApiError(
    @SerializedName("messages")
    var message : String,
    @SerializedName("error")
    var errors: Boolean ?= null,
    @SerializedName("documentation_url")
    var documentation_url: String
)