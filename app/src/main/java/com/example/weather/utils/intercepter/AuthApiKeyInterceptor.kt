package com.example.weather.utils.intercepter;
import android.content.Context
import com.example.weather.utils.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthApiKeyInterceptor(context: Context) : Interceptor {
    private val sessionManager = SessionManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
         //   requestBuilder.addHeader("API_KEY", "9185042346")
        return chain.proceed(requestBuilder.build())
    }
}