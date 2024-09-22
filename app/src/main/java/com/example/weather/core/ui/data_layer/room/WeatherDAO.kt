package com.example.weather.core.ui.data_layer.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weather.core.ui.domain_layer.model.Current
import com.example.weather.core.ui.domain_layer.model.Forecast
import com.example.weather.core.ui.domain_layer.model.Location


@Dao
interface WeatherDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrent(list:Current)

    @Query("SELECT * FROM CURRENT")
    suspend fun getAllCurrent(): Current

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecast(list: List<Forecast>)

    @Query("SELECT * FROM FORECAST")
    suspend fun getAllForecast(): List<Forecast>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(list:Location)

    @Query("SELECT * FROM LOCATION")
    suspend fun getAllLocation(): Location
}
