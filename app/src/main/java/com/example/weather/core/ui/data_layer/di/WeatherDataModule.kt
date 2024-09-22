package com.example.weather.core.ui.data_layer.di

import com.example.weather.core.ui.data_layer.repository.WeatherRepoImpl
import com.example.weather.core.ui.data_layer.room.WeatherDAO
import com.example.weather.core.ui.domain_layer.repository.WeatherRepository
import com.example.weather.network.remote.WeatherApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@InstallIn(SingletonComponent::class)
@Module
object WeatherDataModule {

    @Provides
    fun provideUniversityApiService(retrofit: Retrofit): WeatherApiService {
        return retrofit.create(WeatherApiService::class.java)
    }

    @Provides
    fun providesUniversityRepository(
        universityApiService: WeatherApiService): WeatherRepository {
        return WeatherRepoImpl(universityApiService)
    }
}