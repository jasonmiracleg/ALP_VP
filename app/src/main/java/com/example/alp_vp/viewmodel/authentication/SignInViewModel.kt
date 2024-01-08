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
import com.example.alp_vp.navigation.Screen
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
        viewModelScope.launch() {
            val token: SignInResponse =
                MyDBContainer().tiemerDBRepositories.login(email, password)
            when {
                (token.equals("Incorrect Password") || token.equals("User Not Found")) -> {
                    Toast.makeText(context, "Please Retry the Login", Toast.LENGTH_LONG).show()
                }

                else -> {
                    MyDBContainer.ACCESS_TOKEN = token.token
                    dataStore.saveToken(token.token)
                    dataStore.getToken.collect { token1 ->
                        MyDBContainer.ACCESS_TOKEN = token1.toString()
                        MyDBContainer.USER_ID = token.userId
                        navController.navigate(ListScreen.Home.name) {
                            popUpTo(ListScreen.SignIn.name) { inclusive = true }
                        }
                    }
                }
            }
        }
    }
}