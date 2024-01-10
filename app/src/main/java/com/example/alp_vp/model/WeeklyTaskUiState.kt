package com.example.alp_vp.model

import java.sql.Time

class WeeklyTaskUiState (
    val listDay: ArrayList<ToDoListWeekly> =  arrayListOf(
        ToDoListWeekly(
            day = "Mon",
            arrayListOf(
                ToDoList(
                    id= 0,
                    title =  "Pemrograman Android",
                    listCategory = arrayListOf(
                        Category(title = "Group", color = "FFDC2626"),
                        Category(title = "Urgent", color = "FF22D3EE"),
                        Category(title = "Project", color = "FF2563EB")
                    ),
                    description = "Pengerjaan Android studio",
                    isGroup.group,
                    isComplete.done,
                    Time.valueOf("12:15:00"),
                    totalSeconds = 1
                ),
                ToDoList(
                    id= 0,
                    title = "Kerja Progress ALP VP",
                    listCategory = arrayListOf(
                        Category(title = "Individual", color = "FFFFC107"),
                        Category(title = "Shoping", color = "FF4CAF50"),
                    ),
                    description = "Semangat ALP VP",
                    isGroup.individu,
                    isComplete.progress,
                    Time.valueOf("12:15:00"),
                    totalSeconds = 1
                ),
                ToDoList(
                    id= 0,
                    title = "WebProg",
                    listCategory = arrayListOf(
                        Category(title = "Group", color = "FFDC2626"),
                        Category(title = "Urgent", color = "FF22D3EE"),
                        Category(title = "Project", color = "FF2563EB")
                    ),
                    description = "Semangat ALP VP",
                    isGroup.individu,
                    isComplete.progress,
                    Time.valueOf("12:15:00"),
                    totalSeconds = 1
                )
            )
        ),
        ToDoListWeekly(
            day = "Tue",
            arrayListOf(
                ToDoList(
                    id= 0,
                    title = "Mancing",
                    listCategory = arrayListOf(
                        Category(title = "Individual", color = "FFFFC107")
                    ),
                    description = "Semangat Mancing",
                    isGroup.group,
                    isComplete.done,
                    Time.valueOf("12:15:00"),
                    totalSeconds = 1
                )
            )
        ),
        ToDoListWeekly(
            day = "Wed",
            arrayListOf(
                ToDoList(
                    id= 0,
                    title = "Ethics",
                    listCategory = arrayListOf(
                        Category(title = "Individual", color = "FFFFC107")
                    ),
                    description = "Ethika hidup",
                    isGroup.individu,
                    isComplete.done,
                    Time.valueOf("12:15:00"),
                    totalSeconds = 1
                ),
                ToDoList(
                    id= 0,
                    title = "MathDesc",
                    listCategory = arrayListOf(
                        Category(title = "Shoping", color = "FF673AB7"),
                    ),
                    description = "Math presentasi",
                    isGroup.group,
                    isComplete.done,
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
                    id= 0,
                    title = "Bisnis",
                    listCategory = arrayListOf(
                        Category(title = "Shoping", color = "FF3F51B5"),
                    ),
                    description = "Bisnis Management",
                    isGroup.individu,
                    isComplete.progress,
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