package com.example.alp_vp.repositories

import com.example.alp_vp.service.TiemerService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
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
class TiemerContainer {
    companion object{ // Basically like static function
        var USER_ID = -1
        var ACCESS_TOKEN = ""
    }

    private val BASE_URL = "http://192.168.65.233/laravel-projects/vp_api/public/api/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(ACCESS_TOKEN))
        .build()

    private val retrofit =  Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    private val retrofitService: TiemerService by lazy{
        retrofit.create(TiemerService::class.java)
    }

    val tiemerDBRepositories: TiemerRepository by lazy{
        TiemerRepository(retrofitService)
    }
}