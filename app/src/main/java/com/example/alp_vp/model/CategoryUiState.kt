package com.example.alp_vp.model

data class CategoryUIState(
    val categories: MutableList<Category> = mutableListOf(
        Category(title = "Group", color = "FFDC2626"),
        Category(title = "Urgent", color = "FF22D3EE"),
        Category(title = "Project", color = "FF2563EB"),
        Category(title = "Individual", color = "FFFFC107"),
        Category(title = "Shoping", color = "FF4CAF50"),
    )
)