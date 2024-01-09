package com.example.alp_vp.viewmodel.to_do_list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alp_vp.model.ToDoListV2
import com.example.alp_vp.repository.MyDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ToDoListViewModel : ViewModel() {

//    @RequiresApi(Build.VERSION_CODES.O)
//    private val currentData = MutableStateFlow(ToDoListV2())
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    val data: StateFlow<ToDoListV2> = currentData.asStateFlow()

    @RequiresApi(Build.VERSION_CODES.O)
    fun createToDoList(
        title: String,
        is_group: String,
        description: String,
        date: String,
        day: String
    ) {
        viewModelScope.launch {

            MyDBContainer().tiemerDBRepositories.createToDoList(
                MyDBContainer.ACCESS_TOKEN,
                title,
                is_group,
                description,
                date,
                day
            )
        }
    }

//    fun getAllCategoryForToDoList(accessToken: String, userId: Int) {
//
//        viewModelScope.launch {
//            MyDBContainer().tiemerDBRepositories.getCategories(
//                accessToken,
//                userId
//            )
//        }
//    }
}