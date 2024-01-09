package com.example.alp_vp.repository

import android.util.Log
import com.example.alp_vp.service.MyDBService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthInterceptor(private val bearerToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder()
            .header("Authorization", "Bearer $bearerToken")
            .build()
        return chain.proceed(request)
    }
}

class MyDBContainer {
    companion object{ // Basically like static function
        var USER_ID = -1
        var ACCESS_TOKEN = ""
    }

    private val BASE_URL = "http://192.168.100.18/VP_API/VP_API/public/api/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(ACCESS_TOKEN))
        .build()

    private val retrofit =  Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    private val retrofitService: MyDBService by lazy{
        retrofit.create(MyDBService::class.java)
    }

    val tiemerDBRepositories: MyDBRepositories by lazy{
        MyDBRepositories(retrofitService)
    }
}