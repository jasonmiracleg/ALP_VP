package com.example.alp_vp.model

import java.util.Date

data class Category(
    val id: Int = 0,
    val title: String,
    val color: String,
    var user_id: Int = 0
)



//data class CategoryResponse(
//    val id: Int = 0,
//    val title: String,
//    val color : String,
//    var user_id: Int,
//    var created_at : Date,
//    val updated_at : Date
//)
