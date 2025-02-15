package com.example.weather.utils.intercepter;
import android.content.Context
import com.example.weather.utils.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(context: Context) : Interceptor {
    private val sessionManager = SessionManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()


//        AppApplication.sessionManager.authDetails?.let {
//            requestBuilder.addHeader("Authorization", "Bearer $it")
//        }
        return chain.proceed(requestBuilder.build())
    }
}