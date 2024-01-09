package com.example.alp_vp.viewmodel.authentication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alp_vp.data.DataStoreManager
import com.example.alp_vp.model.User
import com.example.alp_vp.repository.MyDBContainer
import com.example.alp_vp.ui.ListScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {
    fun fillUserData(
        name: String,
        email: String,
        password: String,
        born_date: String,
        navController: NavController,
    ) {
        viewModelScope.launch {
            Log.d("coba", born_date)
            MyDBContainer().tiemerDBRepositories.register(name, email, password, born_date)
            navController.navigate(ListScreen.SignIn.name)
        }
    }

}