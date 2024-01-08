package com.example.alp_vp.repository

import android.util.Log
import com.example.alp_vp.model.APIResponse
import com.example.alp_vp.model.SignInResponse
import com.example.alp_vp.model.User
import com.example.alp_vp.service.MyDBService
import java.net.HttpURLConnection

class MyDBRepositories(private val myDBService: MyDBService) {
    suspend fun login(
        email: String,
        password: String
    ): SignInResponse {
        val user = User(email = email, password = password)
        val result = myDBService.login(user)
        if (result.status.toInt() == HttpURLConnection.HTTP_OK) {
            return result
        }
        Log.d("coba", result.toString())
        return result
    }

    suspend fun logout(): String {
        val result = myDBService.logout()
        return result.message
    }

    suspend fun register(
        name: String,
        email: String,
        password: String,
        born_date: String
    ): String {
        val user = User(name, email, password, born_date)

        val result = myDBService.register(user)
//        if (result.status.toInt() == HttpURLConnection.HTTP_OK) {
//            return result.message
//        }
        Log.d("coba", result.toString())
        return result.message
    }

}