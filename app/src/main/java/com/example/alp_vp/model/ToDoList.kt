package com.example.alp_vp.model

import androidx.compose.ui.graphics.Color

class ToDoList (
    val judul: String,
    val listCategory: ArrayList<Category> = arrayListOf(


    )
)
val todoList1 = ToDoList(
    judul = "Pemrograman Android",
    listCategory = arrayListOf(
        Category(title = "Group", color = "0xFFDC2626"),
        Category(title = "Urgent", color = "0xFF22D3EE"),
        Category(title = "Project", color = "0xFF2563EB")
    )
)

val todoList2 = ToDoList(
    judul = "Kerja Progress ALP VP",
    listCategory = arrayListOf(
        Category(title = "Individual", color = "0xFFFFC107"),
        Category(title = "Shoping", color = "0xFF4CAF50"),
    )
)

val todoList3 = ToDoList(
    judul = "Pemrograman Android",
    listCategory = arrayListOf(
        Category(title = "Group", color = "0xFFDC2626"),
        Category(title = "Urgent", color = "0xFF22D3EE"),
        Category(title = "Project", color = "0xFF2563EB")
    )
)

val todoList4 = ToDoList(
    judul = "Kerja Progress ALP VP",
    listCategory = arrayListOf(
        Category(title = "Individual", color = "0xFFFFC107"),
        Category(title = "Shoping", color = "0xFF4CAF50"),
    )
)

val listMataKuliah = arrayListOf(
    todoList1,
    todoList2,
    todoList3,
    todoList4
)