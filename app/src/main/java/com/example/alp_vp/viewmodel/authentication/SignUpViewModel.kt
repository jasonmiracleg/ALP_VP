package com.example.alp_vp.viewmodel.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alp_vp.model.User
import com.example.alp_vp.navigation.Screen
import com.example.alp_vp.repositories.TiemerContainer
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
        bornDate: String,
        navController: NavController,
    ) {
        viewModelScope.launch {
            val user = User(name, email, password, "12/01/2024")
            val token = TiemerContainer().tiemerDBRepositories.register(user)
            navController.navigate(ListScreen.SignIn.name)
        }
    }

}