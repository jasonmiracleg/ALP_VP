package com.example.alp_vp.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alp_vp.navigation.Screen
import com.example.alp_vp.ui.view.authentication.AuthenticationView
import com.example.alp_vp.ui.view.authentication.EditProfileView
import com.example.alp_vp.ui.view.authentication.SignInView
import com.example.alp_vp.ui.view.authentication.SignUpView
import com.example.alp_vp.ui.view.authentication.SplashScreenView
import com.example.alp_vp.viewmodel.to_do_list.FormCreateViewModel
import com.example.alp_vp.viewmodel.to_do_list.HomeViewModel
import com.example.alp_vp.viewmodel.to_do_list.WeeklyTaskViewModel

enum class ListScreen(){
    Home,
    WeeklyTask,
    FormCreate,
    FormEdit,
    splash_screen,
    authentication,
    sign_in,
    sign_up,
    edit_profile
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Route(){
    val navController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ListScreen.splash_screen.name,
            modifier = Modifier
                .padding(innerPadding)
        ){
            composable(ListScreen.Home.name){
                val homeViewModel: HomeViewModel = viewModel()
            }

            composable(ListScreen.WeeklyTask.name){
                val  weeklyTaskViewModel: WeeklyTaskViewModel = viewModel()
            }

            composable(ListScreen.FormCreate.name){
                val formCreateViewModel: FormCreateViewModel = viewModel ()
            }

            composable(ListScreen.FormEdit.name){
            }

            composable(ListScreen.splash_screen.name){
                SplashScreenView(navController = navController)
            }

            composable(ListScreen.sign_in.name){
                SignInView(navController = navController)
            }

            composable(ListScreen.sign_up.name){
                SignUpView(navController = navController)
            }

            composable(ListScreen.edit_profile.name) {
                EditProfileView(navController = navController)
            }

            composable(ListScreen.authentication.name){
                AuthenticationView(navController = navController)
            }
        }

    }
}

