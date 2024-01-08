package com.example.alp_vp.viewmodel.to_do_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alp_vp.data.DataStoreManager
import com.example.alp_vp.model.HomeUiState
import com.example.alp_vp.repository.MyDBContainer
import com.example.alp_vp.repository.MyDBRepositories
import com.example.alp_vp.ui.ListScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel :ViewModel(){
     private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun logout(
        dataStore : DataStoreManager,
        navController: NavController
    ){
        viewModelScope.launch {
            MyDBContainer().tiemerDBRepositories.logout()
            dataStore.saveToken("",-1)
            MyDBContainer.USER_ID = -1
            MyDBContainer.ACCESS_TOKEN = ""
            navController.navigate(ListScreen.SplashScreen.name)
        }
    }
}