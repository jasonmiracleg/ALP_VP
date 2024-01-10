package com.example.alp_vp.model

data class APIResponse(
    val status: String = "",
    val message: String = "",
    val data: Any
)

data class SignInResponse(
    val status: String = "",
    val message: String = "",
    val userId: Int = 0,
    val token: String = ""
)

data class APIListResponse<T>(
    val status: Int,
    val message: String,
    val data: T
)