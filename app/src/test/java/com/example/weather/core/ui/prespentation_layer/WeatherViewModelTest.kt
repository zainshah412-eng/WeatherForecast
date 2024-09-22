package com.example.weather.core.ui.prespentation_layer

import com.example.weather.core.ui.data_layer.model.WeatherResponse
import com.example.weather.core.ui.domain_layer.usecase.GetWeatherUseCase
import com.example.weather.utils.Resource
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class WeatherViewModelTest {

    private lateinit var weatherViewModel: WeatherViewModel
    private val getWeatherUseCase: GetWeatherUseCase = mockk()

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        weatherViewModel = WeatherViewModel(getWeatherUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test loading state is emitted when fetching weather`() = runTest {
        coEvery { getWeatherUseCase(any()) } returns flow {
            emit(Resource.Loading())
        }
        weatherViewModel.getListing("London")
        val result = weatherViewModel.listing.take(1).first()
        assertTrue(result.isLoading)
    }

    @Test
    fun `test success state is emitted with data`() = runTest {
        val weatherResponse = mockk<WeatherResponse>()
        coEvery { getWeatherUseCase(any()) } returns flow {
            emit(Resource.Loading())
            emit(Resource.Success(weatherResponse))
        }
        val job = launch {
            weatherViewModel.getListing("London")
        }
        val emissions = weatherViewModel.listing.take(2).toList()
        advanceUntilIdle()
        job.cancel()
        assertEquals(2, emissions.size)
        assertTrue(emissions[0].isLoading)
        assertEquals(WeatherState(data = weatherResponse), emissions[1])
    }

    @Test
    fun `test error state is emitted when fetching weather fails`() = runTest {
        val errorMessage = "Failed to fetch weather"
        coEvery { getWeatherUseCase(any()) } returns flow {
            emit(Resource.Error(errorMessage))
        }
        weatherViewModel.getListing("London")
        val result = weatherViewModel.listing.take(2).toList()
        assertTrue(result[0].isLoading)
        assertEquals(WeatherState(error = errorMessage), result[1])
    }
}