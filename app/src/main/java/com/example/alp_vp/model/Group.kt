package com.example.alp_vp.model

data class Group(
    val id: Int = 0,
    val group_name: String,
    val description: String,
    var user_id: Int = 0,
    var members: List<User> = emptyList() //ketambahan satu atribut untuk menyimpan anggota anggota tim
)

//data class Category(
//    val id: Int = 0,
//    val title: String,
//    val color: String,
//    var user_id: Int = 0
//)
