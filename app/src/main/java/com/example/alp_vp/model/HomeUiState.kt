package com.example.alp_vp.model

import java.sql.Time

data class HomeUiState(
    val user: String = "Yobel",
    val todoList: ArrayList<ToDoList> = arrayListOf(
        ToDoList(
            title = "Pemrograman Android",
            listCategory = arrayListOf(
                Category(category_title = "Group", color = "FFDC2626"),
                Category(category_title = "Urgent", color = "FF22D3EE"),
                Category(category_title = "Project", color = "FF2563EB")
            ),
            description = "Pengerjaan Android studio",
            isGroup.individu,
            isComplete.progress,
            Time.valueOf("12:15:00"),
            totalSeconds = 1
        ),
        ToDoList(
            title = "Kerja Progress ALP VP",
            listCategory = arrayListOf(
                Category(category_title = "Individual", color = "FFFFC107"),
                Category(category_title = "Shoping", color = "FF4CAF50"),
            ),
            description = "Semangat ALP VP",
            isGroup.individu,
            isComplete.progress,
            Time.valueOf("12:15:00"),
            totalSeconds = 1
        ),
        ToDoList(
            title = "WebProg",
            listCategory = arrayListOf(
                Category(category_title = "Group", color = "FFDC2626"),
                Category(category_title = "Urgent", color = "FF22D3EE"),
                Category(category_title = "Project", color = "FF2563EB")
            ),
            description = "Semangat ALP VP",
            isGroup.individu,
            isComplete.progress,
            Time.valueOf("12:15:00"),
            totalSeconds = 1
        ),
        ToDoList(
            title = "Civics",
            listCategory = arrayListOf(
                Category(category_title = "Individual", color = "FFFFC107"),
                Category(category_title = "Shoping", color = "FF4CAF50"),
            ),
            description = "Civics buat proposal",
            isGroup.individu,
            isComplete.progress,
            Time.valueOf("12:15:00"),
            totalSeconds = 1
        ),
        ToDoList(
            title = "Ethics",
            listCategory = arrayListOf(
                Category(category_title = "Individual", color = "FFFFC107")
            ),
            description = "Ethics Individu",
            isGroup.individu,
            isComplete.progress,
            Time.valueOf("12:15:00"),
            totalSeconds = 1
        ),
        ToDoList(
            title = "MathDesc",
            listCategory = arrayListOf(
                Category(category_title = "Shoping", color = "FF673AB7"),
            ),
            description = "Math buat presentasi",
            isGroup.individu,
            isComplete.progress,
            Time.valueOf("12:15:00"),
            totalSeconds = 1
        ),
        ToDoList(
            title = "Bisnis",
            listCategory = arrayListOf(
                Category(category_title = "Shoping", color = "FF3F51B5"),
            ),
            description = "Kerja Rodi bagai kuda",
            isGroup.individu,
            isComplete.progress,
            Time.valueOf("12:15:00"),
            totalSeconds = 1
        )
    )
)
