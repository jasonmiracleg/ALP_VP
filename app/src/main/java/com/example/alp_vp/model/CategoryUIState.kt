package com.example.alp_vp.model

data class CategoryUIState(
    val categories: MutableList<Category> = mutableListOf(
        Category(category_title = "Group", color = "FFDC2626"),
        Category(category_title = "Urgent", color = "FF22D3EE"),
        Category(category_title = "Project", color = "FF2563EB"),
        Category(category_title = "Individual", color = "FFFFC107"),
        Category(category_title = "Shoping", color = "FF4CAF50"),
    )
)
