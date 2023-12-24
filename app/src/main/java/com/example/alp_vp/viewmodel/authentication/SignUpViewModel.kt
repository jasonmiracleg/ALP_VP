package com.example.alp_vp.viewmodel.authentication

import androidx.lifecycle.ViewModel
import com.example.alp_vp.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel : ViewModel() {

    private val _uistate = MutableStateFlow<List<User>>(emptyList())
    val uistate: StateFlow<List<User>> = _uistate.asStateFlow()

    fun fillUserData(name: String, email: String, password: String, bornDate: String) {

        val newUser = User(name, email, password, bornDate)
        _uistate.value = _uistate.value + newUser

    }


}