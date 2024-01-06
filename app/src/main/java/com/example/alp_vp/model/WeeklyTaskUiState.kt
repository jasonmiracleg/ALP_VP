package com.example.alp_vp.model

import java.sql.Time

class WeeklyTaskUiState (
    val listDay: ArrayList<ToDoListWeekly> =  arrayListOf(
        ToDoListWeekly(
            day = "Mon",
            arrayListOf(
                ToDoList(
                    title =  "Pemrograman Android",
                    listCategory = arrayListOf(
                        Category(category_title = "Group", color = "FFDC2626"),
                        Category(category_title = "Urgent", color = "FF22D3EE"),
                        Category(category_title = "Project", color = "FF2563EB")
                    ),
                    description = "Pengerjaan Android studio",
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
                    Time.valueOf("12:15:00"),
                    totalSeconds = 1
                )
            )
        ),
        ToDoListWeekly(
            day = "Tue",
            arrayListOf(
                ToDoList(
                    title = "Mancing",
                    listCategory = arrayListOf(
                        Category(category_title = "Individual", color = "FFFFC107")
                    ),
                    description = "Semangat Mancing",
                    Time.valueOf("12:15:00"),
                    totalSeconds = 1
                )
            )
        ),
        ToDoListWeekly(
            day = "Wed",
            arrayListOf(
                ToDoList(
                    title = "Ethics",
                    listCategory = arrayListOf(
                        Category(category_title = "Individual", color = "FFFFC107")
                    ),
                    description = "Ethika hidup",
                    Time.valueOf("12:15:00"),
                    totalSeconds = 1
                ),
                ToDoList(
                    title = "MathDesc",
                    listCategory = arrayListOf(
                        Category(category_title = "Shoping", color = "FF673AB7"),
                    ),
                    description = "Math presentasi",
                    Time.valueOf("12:15:00"),
                    totalSeconds = 1
                )
            )
        ),
        ToDoListWeekly(
            day = "Thur"
        ),
        ToDoListWeekly(
            day = "Fri",
            arrayListOf(
                ToDoList(
                    title = "Bisnis",
                    listCategory = arrayListOf(
                        Category(category_title = "Shoping", color = "FF3F51B5"),
                    ),
                    description = "Bisnis Management",
                    Time.valueOf("12:15:00"),
                    totalSeconds = 1
                )
            )
        ),
        ToDoListWeekly(
            day = "Sat"
        )
    )
)