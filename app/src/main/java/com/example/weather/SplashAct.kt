package com.example.weather

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.weather.databinding.ActivitySplashBinding
import com.example.weather.core.ui.prespentation_layer.MainActivity
import kotlinx.coroutines.*

class SplashAct : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    private var coroutineScope: Job? = null
    private val NAVIGATION_DELAY = 1 * 1000L // 2 sec of delay
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coroutineScope = CoroutineScope(Job() + Dispatchers.Main).launch {
            delay(NAVIGATION_DELAY)

            coroutineScope?.let {
                if (it.isActive) {
                        val intent = Intent(this@SplashAct, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                }
            }
        }

        askNotificationPermission()
    }

    // Declare the launcher at the top of your Activity/Fragment:
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // FCM SDK (and your app) can post notifications.
        } else {
            // TODO: Inform user that that your app will not show notifications.
        }
    }

    // ...
    @RequiresApi(Build.VERSION_CODES.M)
    private fun askNotificationPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_NOTIFICATION_POLICY
            ) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            // FCM SDK (and your app) can post notifications.
        } else if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_NOTIFICATION_POLICY)) {
            // TODO: display an educational UI explaining to the user the features that will be enabled
            //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
            //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
            //       If the user selects "No thanks," allow the user to continue without notifications.
        } else {
            // Directly ask for the permission
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_NOTIFICATION_POLICY)
        }

    }
}