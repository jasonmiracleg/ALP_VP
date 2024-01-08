package com.example.alp_vp.viewmodel.to_do_list

import androidx.lifecycle.ViewModel
import com.example.alp_vp.model.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel :ViewModel(){
     private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()


}