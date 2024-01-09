package com.example.alp_vp.viewmodel.category

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alp_vp.model.APIListResponse
import com.example.alp_vp.model.APIResponse
import com.example.alp_vp.model.Category
import com.example.alp_vp.repository.MyDBContainer
import com.example.alp_vp.ui.ListScreen
import kotlinx.coroutines.launch
import retrofit2.Response

sealed interface CategoryUIState {
    data class Success(val user: Int, val listCategory: Response<APIListResponse<List<Category>>>) :
        CategoryUIState

    object Error : CategoryUIState
    object Loading : CategoryUIState
}

class CategoryViewModel : ViewModel() {
//    private val _categoriesData = MutableStateFlow<CategoryResponse?>(null)
//    val categoriesData: StateFlow<CategoryResponse?> get() = _categoriesData.asStateFlow()

    var categoryUIState: CategoryUIState by mutableStateOf(CategoryUIState.Loading)
        private set

    lateinit var allCategory: Response<APIListResponse<List<Category>>>

    init {
        initialCategoryUIState()
    }

    fun createCategory(category_title: String, color: String, navController: NavController) {
        viewModelScope.launch {
            val userId = MyDBContainer.USER_ID
            val token = MyDBContainer.ACCESS_TOKEN
            MyDBContainer().tiemerDBRepositories.createCategory(
                category_title, color, userId, token
            )
            navController.navigate(ListScreen.Category.name)
        }
    }

    fun deleteCategory(id: Int, navController: NavController) {
        viewModelScope.launch {
            val token = MyDBContainer.ACCESS_TOKEN
            MyDBContainer().tiemerDBRepositories.deleteCategory(
                token, id
            )
            navController.navigate(ListScreen.Category.name)
        }
    }

    private fun initialCategoryUIState() {
        viewModelScope.launch {
            allCategory = MyDBContainer().tiemerDBRepositories.getCategories(
                MyDBContainer.ACCESS_TOKEN,
                MyDBContainer.USER_ID
            )
            Log.d("Category", allCategory.toString())
            categoryUIState = CategoryUIState.Success(MyDBContainer.USER_ID, allCategory)
        }
    }
}



