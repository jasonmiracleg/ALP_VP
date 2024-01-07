package com.example.alp_vp.viewmodel.authentication

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.alp_vp.model.User
import com.example.alp_vp.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignInViewModel : ViewModel(){
    private val _userData = MutableStateFlow(User())
    val userData: StateFlow<User> = _userData.asStateFlow()
    fun logIn(email: String, password: String, navController: NavController) {
        if (_userData.value.email == email && _userData.value.password == password) {
            navController.navigate(Screen.EditProfile.route)
        }
    }
}