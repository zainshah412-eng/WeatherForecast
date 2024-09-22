package com.example.weather.core.ui.prespentation_layer

import android.view.inputmethod.EditorInfo
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.material.textfield.TextInputEditText
import hideKeyboard
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import java.lang.reflect.Field

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var searchBar: TextInputEditText

    private lateinit var mainActivity: MainActivity
    private lateinit var mockViewModel: WeatherViewModel

    @Before
    fun setup() {
        mainActivity = MainActivity()
        mockViewModel = mock(WeatherViewModel::class.java)

        val field: Field = MainActivity::class.java.getDeclaredField("listingViewModel")
        field.isAccessible = true
        field.set(mainActivity, mockViewModel)
    }

    @Test
    fun testSearchBarWithValidInput() = runTest {
        val validInput = "London"
        `when`(searchBar.text.toString()).thenReturn(validInput)
        searchBar.onEditorAction(EditorInfo.IME_ACTION_DONE)

        verify(searchBar).hideKeyboard()
        verify(mockViewModel).getListing(validInput)
    }

    @Test
    fun testSearchBarWithInvalidInput() = runTest {
        val invalidInput = "NY"
        `when`(searchBar.text.toString()).thenReturn(invalidInput)
        searchBar.onEditorAction(EditorInfo.IME_ACTION_DONE)

        verify(searchBar, never()).hideKeyboard()
        verify(mockViewModel, never()).getListing(invalidInput)
    }
}