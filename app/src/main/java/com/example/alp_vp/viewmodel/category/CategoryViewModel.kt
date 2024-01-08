package com.example.alp_vp.viewmodel.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alp_vp.model.Category
import com.example.alp_vp.model.CategoryResponse
import com.example.alp_vp.model.CategoryUIState
import com.example.alp_vp.repository.MyDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    private val _categoriesData = MutableStateFlow<CategoryResponse?>(null)
    val categoriesData: StateFlow<CategoryResponse?> get() = _categoriesData.asStateFlow()

    fun createCategory(category_title: String, color: String) {
        viewModelScope.launch {
            val userId = MyDBContainer.USER_ID
            val token = MyDBContainer.ACCESS_TOKEN
            MyDBContainer().tiemerDBRepositories.createCategory(
                category_title, color, userId, token
            )
        }
//        val categoryList = currentData.value.categories.toMutableList()
//        categoryList.add(Category(category_title = title, color = color))
//        currentData.update {
//            it.copy(categories = categoryList)
    }

    fun categories() {
        viewModelScope.launch {
            val userId = MyDBContainer.USER_ID
            val token = MyDBContainer.ACCESS_TOKEN
            val categories = MyDBContainer().tiemerDBRepositories.getCategories(token, userId)
            _categoriesData.value = categories
        }
    }
}

