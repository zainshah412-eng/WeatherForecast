package com.example.weather

import android.content.Context
import com.example.weather.core.db.AppDatabase
import com.example.weather.core.ui.data_layer.room.WeatherDAO
import com.example.weather.core.ui.domain_layer.repository.WeatherRepository
import com.example.weather.core.ui.domain_layer.usecase.GetWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MainModule {
    @Provides
    @Singleton
    fun provideListingDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideListingDAO(appDatabase: AppDatabase): WeatherDAO {
        return appDatabase.getListing()
    }

    @Provides
    @Singleton
    fun provideGetWeatherUseCase(weatherRepository: WeatherRepository): GetWeatherUseCase {
        return GetWeatherUseCase(weatherRepository)
    }
}