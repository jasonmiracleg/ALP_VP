package com.example.alp_vp.repository

import android.util.Log
import com.example.alp_vp.model.APIListResponse
import com.example.alp_vp.model.APIResponse
import com.example.alp_vp.model.Category
import com.example.alp_vp.model.SignInResponse
import com.example.alp_vp.model.ToDoList
import com.example.alp_vp.model.ToDoListComplete
import com.example.alp_vp.model.ToDoListCreate
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

    suspend fun createToDoList(
        token: String,
        title: String,
        is_group: String,
        description: String,
        date: String,
        day: String
    ) {
        val toDoListCreateVar = ToDoListCreate(
            title = title,
            is_group = is_group,
            description = description,
            date = date,
            day = day
        )
        val createToDoList = myDBService.createToDoList(token, toDoListCreateVar)
        Log.d("coba1", createToDoList.toString())
        return createToDoList
    }

    suspend fun getAllToDoList(
        token: String,
        userId: Int
    ): Response<APIListResponse<List<ToDoList>>> {
        //        Log.d("gabisa", myDBService.getAllToDoList(token).toString())
        return myDBService.getAllToDoList(token, userId)
    }

    suspend fun updateCompleteToDoListToDay(
        token: String,
        data: ToDoList,
        result: Boolean
    ) {
        var toDoList = data.id
        Log.d("tdl",toDoList.toString())
        if (result) {
            val is_complete_tdl = ToDoListComplete(
                id = toDoList,
                is_complete = "1"
            )
            return myDBService.updateComplete(token, is_complete_tdl)
        } else {
            val is_complete_tdl = ToDoListComplete(
                id = toDoList,
                is_complete = "0"
            )
            return myDBService.updateComplete(token, is_complete_tdl)

        }

    }
}