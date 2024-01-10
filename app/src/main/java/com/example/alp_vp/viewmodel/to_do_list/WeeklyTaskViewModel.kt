package com.example.alp_vp.viewmodel.to_do_list

import androidx.lifecycle.ViewModel

import com.example.alp_vp.model.WeeklyTaskUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeeklyTaskViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(WeeklyTaskUiState())
    val uiState: StateFlow<WeeklyTaskUiState> = _uiState.asStateFlow()

//    fun getAllToDoList() {
//
//        viewModelScope.launch {
//            MyDBContainer().tiemerDBRepositories.getAllToDoList(
//                MyDBContainer.ACCESS_TOKEN
//            )
//        }
//
//    }

}