package com.example.weather.core.ui.domain_layer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Forecast(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var date: String,
    var maxtempC: Double?,
    var mintempC: Double?,
    var icon: String?,
    var text: String?
)
