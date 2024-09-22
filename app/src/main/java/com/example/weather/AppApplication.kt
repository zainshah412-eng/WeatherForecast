package com.example.weather

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import com.example.weather.utils.SessionManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppApplication: Application() {
    private val TAG = AppApplication::class.simpleName
    companion object {
        lateinit var instance: Application
        lateinit var sessionManager: SessionManager
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun initialize() {
        instance = this
        sessionManager = SessionManager(applicationContext)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
    override fun onTerminate() {
        super.onTerminate()
    }


}