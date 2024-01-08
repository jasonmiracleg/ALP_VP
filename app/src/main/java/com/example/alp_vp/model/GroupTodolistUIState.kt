package com.example.alp_vp.model

data class GroupTodolistUIState(
    val groupTasks: MutableList<GroupTodolist> = mutableListOf(
        GroupTodolist("Mengerjakan Figma", "Deadline Hari Minggu, pukul 23:59")
    )
)