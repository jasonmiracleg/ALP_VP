package com.example.alp_vp.model

data class APIResponse (
    val status:String = "",
    val message:String = "",
    val data: Any
)

data class SignInResponse(
    val status: String = "",
    val message: String = "",
    val userId : Int = 0,
    val token: String = ""
)