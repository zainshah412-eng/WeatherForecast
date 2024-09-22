package com.example.weather.core.ui.domain_layer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Current(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var lastUpdated: String,
    var tempC: Double?,
    var windKph: Double?,
    var humidity: Int?,
    var feelslikeC: Double?,
    var icon: String?,
    var text: String?
)
