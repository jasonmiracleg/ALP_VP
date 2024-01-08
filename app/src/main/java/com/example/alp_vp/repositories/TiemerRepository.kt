package com.example.alp_vp.repositories

import android.util.Log
import com.example.alp_vp.model.APIResponse
import com.example.alp_vp.model.SignInResponse
import com.example.alp_vp.model.User
import com.example.alp_vp.service.TiemerService
import java.net.HttpURLConnection

class TiemerRepository(private val tiemerService: TiemerService) {
    suspend fun login(
        email: String,
        password: String
    ): SignInResponse {
        val user = User(email = email, password = password)
        val result = tiemerService.login(user)
        if (result.status.toInt() == HttpURLConnection.HTTP_OK) {
            return result
        }
        return result
    }

    suspend fun logout(): String {
        val result = tiemerService.logout()
        return result.message
    }

    suspend fun register(user: User): APIResponse {
        Log.d("coba", user.toString())
        val result = tiemerService.register(user)
        if (result.status.toInt() == HttpURLConnection.HTTP_OK) {
            return result
        }
        return result
    }

}