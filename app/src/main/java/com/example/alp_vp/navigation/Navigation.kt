package com.example.alp_vp.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.alp_vp.ui.view.authentication.AuthenticationView
import com.example.alp_vp.ui.view.authentication.EditProfileView
import com.example.alp_vp.ui.view.authentication.SignInView
import com.example.alp_vp.ui.view.authentication.SignUpView
import com.example.alp_vp.ui.view.authentication.SplashScreenView

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(
    navController: NavHostController,
) {

//    NavHost(
//        navController = navController,
//        startDestination = Screen.Splash.route
//    ) {
//
//        composable(
//            route = Screen.Splash.route
//        ) {
//            SplashScreenView(navController = navController)
//        }
//
//        composable(
//            route = Screen.Authentication.route
//        ) {
//            AuthenticationView(navController = navController)
//        }
//
//        composable(
//            route = Screen.SignIn.route
//        ) {
//            SignInView(navController = navController)
//        }
//
//        composable(
//            route = Screen.SignUp.route
//        ) {
//            SignUpView(navController = navController)
//        }
//
//        composable(
//            route = Screen.EditProfile.route
//        ) {
//            EditProfileView(navController = navController)
//        }
//
//
//    }
}