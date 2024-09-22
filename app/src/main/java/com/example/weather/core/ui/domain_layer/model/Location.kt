package com.example.weather.core.ui.domain_layer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Location(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var region: String?,
    var country: String?,
    var localtime: String?,
)
