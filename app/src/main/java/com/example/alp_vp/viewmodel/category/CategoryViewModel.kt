package com.example.alp_vp.viewmodel.category

import androidx.lifecycle.ViewModel
import com.example.alp_vp.model.Category
import com.example.alp_vp.model.CategoryUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CategoryViewModel : ViewModel() {
    private val currentData = MutableStateFlow(CategoryUIState())
    val data: StateFlow<CategoryUIState> = currentData.asStateFlow()

    fun addCategory(title: String, color: String) {
        val categoryList = currentData.value.categories.toMutableList()
        categoryList.add(Category(category_title = title, color = color))
        currentData.update {
            it.copy(categories = categoryList)
        }
    }

}