package com.example.alp_vp.viewmodel.authentication

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.alp_vp.model.User
import com.example.alp_vp.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel : ViewModel() {
    private val _userData = MutableStateFlow(User())
    val userData: StateFlow<User> = _userData.asStateFlow()
    fun fillUserData(image: String, name: String, email: String, password: String, bornDate: String, navController: NavController) {
        val user = User(image, name, email, password, bornDate)
        _userData.value = user
        navController.navigate(Screen.SignIn.route)
    }

}