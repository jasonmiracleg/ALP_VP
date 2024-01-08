package com.example.alp_vp.viewmodel.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alp_vp.data.DataStoreManager
import com.example.alp_vp.model.User
import com.example.alp_vp.navigation.Screen
import com.example.alp_vp.repository.MyDBContainer
import com.example.alp_vp.ui.ListScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {
    fun fillUserData(
        image: String,
        name: String,
        email: String,
        password: String,
        bornDate: String,
        navController: NavController,
        dataStore: DataStoreManager
    ) {
        viewModelScope.launch {
            val user = User(image, name, email, password, bornDate)
            try {
                val token = MyDBContainer().tiemerDBRepositories.register(user)
                navController.navigate(ListScreen.SignIn.name)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

}