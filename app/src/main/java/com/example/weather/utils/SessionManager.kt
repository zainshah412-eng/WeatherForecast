package com.example.weather.utils;

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.weather.core.ui.data_layer.model.WeatherResponse

import com.example.weather.core.ui.prespentation_layer.MainActivity
import com.google.gson.Gson


class SessionManager(
    // Context
    var _context: Context,
) {
    var pref: SharedPreferences

    // Editor for Shared preferences
    var editor: SharedPreferences.Editor

    // Shared pref mode
    var PRIVATE_MODE = 0

    val weatherDetail: WeatherResponse?
        get() {
            if (pref.getString(KEY_WEATHER, "") != null) {
                val json: String? = pref.getString(KEY_WEATHER, "")
                return Gson().fromJson(json, WeatherResponse::class.java)
            } else {
                return Gson().fromJson("", WeatherResponse::class.java)
            }
        }

    fun saveWeatherDetail(weatherDetail: WeatherResponse?) {
        editor.remove(KEY_WEATHER)
        editor.commit()
        val json = Gson().toJson(weatherDetail)
        editor.putString(KEY_WEATHER, json)
        editor.commit()
    }

    val IsDataFound: Boolean
        get() = pref.getBoolean(IS_DATA_FOUND, false)

    fun dataStore(flag:Boolean) {
        editor.putBoolean(IS_DATA_FOUND, flag)
        editor.commit()
    }

    companion object {
        // Shared pref file name
        private const val PREF_NAME = "SPF_PREF"

        // All Shared Preferences Keys
        const val KEY_WEATHER = "weatherDetail"
        private const val IS_DATA_FOUND = "IsDataFound"


    }

    // Constructor
    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
        editor.apply()
    }
}