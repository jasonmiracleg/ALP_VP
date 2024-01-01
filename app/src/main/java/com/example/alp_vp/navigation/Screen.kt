package com.example.alp_vp.navigation

sealed class Screen(val route: String) {

    object Splash: Screen(route = "splash_screen")
    object Authentication : Screen(route = "authentication")
    object SignIn : Screen(route = "sign_in")
    object SignUp : Screen(route = "sign_up")
    object EditProfile : Screen(route = "edit_profile")

}