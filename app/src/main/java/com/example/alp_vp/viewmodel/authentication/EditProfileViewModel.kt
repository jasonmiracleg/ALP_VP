package com.example.alp_vp.viewmodel.authentication

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.alp_vp.model.User
import com.example.alp_vp.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EditProfileViewModel : ViewModel() {

    private val _userData = MutableStateFlow(User())
    val userData: StateFlow<User> = _userData.asStateFlow()


    fun updateData(image1: String, name1: String, email1: String, password1: String, bornDate1: String, navController: NavController) {
        _userData.update {
            it.copy (
                image = image1,
                name = "hahoh",
                email = email1,
                password = password1,
                bornDate = bornDate1
            )

        }
    }

    fun changeName(name: String) {
        _userData.update {
            it.copy(
                name = name
            )
        }
    }


}