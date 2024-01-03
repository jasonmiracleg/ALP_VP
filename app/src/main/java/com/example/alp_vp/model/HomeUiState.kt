package com.example.alp_vp.model

data class HomeUiState(
    val user: String = "Yobel",
    val todoList: ArrayList<ToDoList> = arrayListOf(
        ToDoList(
            judul = "Pemrograman Android",
            listCategory = arrayListOf(
                Category(title = "Group", color = "FFDC2626"),
                Category(title = "Urgent", color = "FF22D3EE"),
                Category(title = "Project", color = "FF2563EB")
            )
        ),
        ToDoList(
            judul = "Kerja Progress ALP VP",
            listCategory = arrayListOf(
                Category(title = "Individual", color = "FFFFC107"),
                Category(title = "Shoping", color = "FF4CAF50"),
            )
        ),
        ToDoList(
            judul = "WebProg",
            listCategory = arrayListOf(
                Category(title = "Group", color = "FFDC2626"),
                Category(title = "Urgent", color = "FF22D3EE"),
                Category(title = "Project", color = "FF2563EB")
            )
        ),
        ToDoList(
            judul = "Civics",
            listCategory = arrayListOf(
                Category(title = "Individual", color = "FFFFC107"),
                Category(title = "Shoping", color = "FF4CAF50"),
            )
        ),
        ToDoList(
            judul = "Ethics",
            listCategory = arrayListOf(
                Category(title = "Individual", color = "FFFFC107")
            )
        ),
        ToDoList(
            judul = "MathDesc",
            listCategory = arrayListOf(
                Category(title = "Shoping", color = "FF673AB7"),
            )
        ),
        ToDoList(
            judul = "Bisnis",
            listCategory = arrayListOf(
                Category(title = "Shoping", color = "FF3F51B5"),
            )
        )
    )
)
