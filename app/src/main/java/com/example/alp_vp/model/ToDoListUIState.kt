package com.example.alp_vp.model

import java.sql.Time

data class ToDoListUIState(
    val toDoLists: MutableList<ToDoList> = mutableListOf(
        ToDoList(
            title = "",
            description = "",
            isGroup = isGroup.group,
            isComplete = isComplete.done,
            timer = Time.valueOf("12:30:00")
        )
    ),
) {
}