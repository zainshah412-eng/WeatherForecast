package com.example.weather.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weather.core.ui.data_layer.room.WeatherDAO
import com.example.weather.core.ui.domain_layer.model.Current
import com.example.weather.core.ui.domain_layer.model.Forecast
import com.example.weather.core.ui.domain_layer.model.Location
import com.example.weather.core.ui.domain_layer.model.Weather

@Database(entities = [Current::class,Location::class,Forecast::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
                .fallbackToDestructiveMigration().build()
        }
    }

    abstract fun getListing(): WeatherDAO
}