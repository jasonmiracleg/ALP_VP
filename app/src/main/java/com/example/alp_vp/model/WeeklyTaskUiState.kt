package com.example.alp_vp.model

class WeeklyTaskUiState (
    val listDay: ArrayList<ToDoListWeekly> = arrayListOf(
        ToDoListWeekly(
            day = "Mon",
            arrayListOf(
                ToDoList(
                    judul = "Pemrograman Android",
                    listCategory = arrayListOf(
                        Category(title = "Group", color = "FFDC2626"),
                        Category(title = "Urgent", color = "FF22D3EE"),
                        Category(title = "Project", color = "FF2563EB")
                    )
                ),
                ToDoList(
                    judul = "VisProg",
                    listCategory = arrayListOf(
                        Category(title = "Urgent", color = "FF22D3EE"),
                        Category(title = "Project", color = "FF2563EB")
                    )
                ),
                ToDoList(
                    judul = "Civics",
                    listCategory = arrayListOf(
                        Category(title = "Project", color = "FF2563EB")
                    )
                )
            )
        ),
        ToDoListWeekly(
            day = "Tue",
            arrayListOf(
                ToDoList(
                    judul = "Mancing",
                    listCategory = arrayListOf(
                        Category(title = "Individual", color = "FFFFC107")
                    )
                )
            )
        ),
        ToDoListWeekly(
            day = "Wed",
            arrayListOf(
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
                    judul = "Bisnis",
                    listCategory = arrayListOf(
                        Category(title = "Shoping", color = "FF3F51B5"),
                    )
                )
            )
        ),
        ToDoListWeekly(
            day = "Sat"
        )
    )
)