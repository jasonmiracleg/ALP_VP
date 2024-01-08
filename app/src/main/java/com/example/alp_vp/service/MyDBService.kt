package com.example.alp_vp.service

import com.example.alp_vp.model.APIResponse
import com.example.alp_vp.model.SignInResponse
import com.example.alp_vp.model.User
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MyDBService {

    @GET("categories")
    suspend fun getCategories(): APIResponse

    @GET("toDoList-category/{category}")
    suspend fun getCategoryWithTDL(
        @Path("category") id: String
    ): APIResponse

    @GET("all_toDoList/{userId}") // It isn't used I think
    suspend fun getAllTDL(
        @Path("userId") userId: String
    ): APIResponse

    @GET("today_toDoList/{userId}")
    suspend fun getTodayTDL(
        @Path("userId") userId: String
    ): APIResponse

    @GET("tasks-byDay")
    suspend fun getTDLByDay(): APIResponse

    @GET("group-toDoList/{groupId}")
    suspend fun getGroupTDL(
        @Path("groupId") groupId: String
    ): APIResponse

    @GET("groups/{userId}")
    suspend fun getGroups(
        @Path("userId") userId: String
    ): APIResponse

    @GET("group-members/{group}")
    suspend fun getMembers(
        @Path("group") id: String
    ): APIResponse

    @GET("timer_state")
    suspend fun getTimerState(): APIResponse

    @POST("login")
    suspend fun login(@Body user: User): SignInResponse

    @POST("create_user")
    suspend fun register(@Body user: User): APIResponse

    @POST("update_user")
    suspend fun updateUser(): APIResponse

    @POST("create_category")
    suspend fun createCategory(): APIResponse

    @POST("categorizing/{toDoList}") // category_ids bentuk array
    suspend fun setCategory(
        @Path("toDoList") id: String
    ): APIResponse

    @POST("create_toDoList/{userId}")
    suspend fun createTDL(
        @Path("userId") userId: String
    ): APIResponse

    @POST("update_toDoList/{toDoList")
    suspend fun updateTDL(
        @Path("toDoList") id: String
    ): APIResponse

    @POST("create-toDoList-group")
    suspend fun createGroupTDL(): APIResponse

    @POST("group/{group}/toDoList/{toDoList}")
    suspend fun updateGroupTDL(
        @Path("group") groupId: String,
        @Path("toDoList") id: String
    ): APIResponse

    @POST("create_group")
    suspend fun createGroup(): APIResponse

    @POST("timer_start")
    suspend fun startTimer(): APIResponse

    @POST("timer_stop")
    suspend fun stopTimer(): APIResponse

    @DELETE("logout")
    suspend fun logout(): APIResponse

    @DELETE("delete_category")
    suspend fun deleteCategory(): APIResponse

    @DELETE("delete_toDoList")
    suspend fun deleteTDL(): APIResponse

    @DELETE("delete_group")
    suspend fun deleteGroup(): APIResponse
}