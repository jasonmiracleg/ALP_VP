package com.example.alp_vp.repository

import android.util.Log
import com.example.alp_vp.model.APIListResponse
import com.example.alp_vp.model.APIResponse
import com.example.alp_vp.model.Category
import com.example.alp_vp.model.SignInResponse
import com.example.alp_vp.model.User
import com.example.alp_vp.service.MyDBService
import retrofit2.Response
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

    suspend fun createCategory(
        category_title: String,
        color: String,
        user_id: Int,
        token: String
    ): APIResponse {
        val category = Category(title = category_title, color = color, user_id = user_id)
        val result = myDBService.createCategory(token, category)
        if (result.status.toInt() == HttpURLConnection.HTTP_OK) {
            return result
        }
        return result
    }

    suspend fun getCategories(
        token: String,
        userId: Int
    ): Response<APIListResponse<List<Category>>> {
        Log.d("Category", "$userId ${token}")
        return myDBService.getCategories(token, userId)
    }

    suspend fun deleteCategory(token: String, id: Int): APIResponse {
        Log.d("DeleteCategory", "$id ${token}")
        val result = myDBService.deleteCategory(token, id)
        if (result.status.toInt() == HttpURLConnection.HTTP_OK) {
            return result
        }
        return result
    }
}