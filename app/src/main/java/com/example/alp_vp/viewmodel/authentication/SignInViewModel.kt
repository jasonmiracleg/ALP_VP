package com.example.alp_vp.viewmodel.authentication

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alp_vp.data.DataStoreManager
import com.example.alp_vp.model.SignInResponse
import com.example.alp_vp.model.User
import com.example.alp_vp.repository.MyDBContainer
import com.example.alp_vp.ui.ListScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {
    fun logIn(
        email: String,
        password: String,
        navController: NavController,
        context: Context,
        dataStore: DataStoreManager
    ) {
        viewModelScope.launch {
            val token: SignInResponse =
                MyDBContainer().tiemerDBRepositories.login(email, password)
            when {
                (token.message == "Incorrect Password" || token.message == "User Not Found") -> {
                    Toast.makeText(context, "Please Retry the Login", Toast.LENGTH_LONG).show()
                }
                else -> {
                    dataStore.saveToken(token.token, token.userId)
                    MyDBContainer.USER_ID = token.userId
                    dataStore.getToken.collect { currentToken ->
                        MyDBContainer.ACCESS_TOKEN = currentToken.toString()
                        navController.navigate(ListScreen.Home.name) {
                            popUpTo(ListScreen.SignIn.name) { inclusive = true }
                        }
                    }
                }
            }
        }
    }
}