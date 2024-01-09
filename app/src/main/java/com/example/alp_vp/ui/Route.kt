package com.example.alp_vp.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.GroupAdd
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.alp_vp.data.DataStoreManager
import com.example.alp_vp.repository.MyDBContainer
import com.example.alp_vp.repository.MyDBRepositories
import com.example.alp_vp.ui.component.BottomNavbar
import com.example.alp_vp.ui.theme.BlueTheme
import com.example.alp_vp.ui.view.authentication.AuthenticationView
import com.example.alp_vp.ui.view.authentication.EditProfileView
import com.example.alp_vp.ui.view.authentication.SignInView
import com.example.alp_vp.ui.view.authentication.SignUpView
import com.example.alp_vp.ui.view.authentication.SplashScreenView
import com.example.alp_vp.ui.view.category.ViewCategory
import com.example.alp_vp.ui.view.to_do_list.HomeView
import com.example.alp_vp.viewmodel.authentication.SignInViewModel
import com.example.alp_vp.viewmodel.authentication.SignUpViewModel
import com.example.alp_vp.viewmodel.category.CategoryViewModel
import com.example.alp_vp.viewmodel.to_do_list.FormCreateViewModel
import com.example.alp_vp.viewmodel.to_do_list.HomeViewModel
import com.example.alp_vp.viewmodel.to_do_list.WeeklyTaskViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

enum class ListScreen() {
    Home,
    WeeklyTask,
    FormCreate,
    FormEdit,
    SplashScreen,
    Authentication,
    SignIn,
    SignUp,
    EditProfile,
    Group,
    Category
}

sealed class BottomNavBar(var menu: String, var icon: ImageVector, var route: String) {
    object Home : BottomNavBar("Home", Icons.Outlined.Home, ListScreen.Home.name)
    object Weekly : BottomNavBar("Weekly", Icons.Outlined.CalendarMonth, ListScreen.WeeklyTask.name)
    object Groups : BottomNavBar("Group", Icons.Outlined.GroupAdd, ListScreen.Group.name)
    object Urgency : BottomNavBar("Urgency", Icons.Outlined.Category, ListScreen.Category.name)
}

@Composable
fun BottomNavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val items = listOf(
        BottomNavBar.Home,
        BottomNavBar.Weekly,
        BottomNavBar.Groups,
        BottomNavBar.Urgency
    )

    NavigationBar(
        modifier = Modifier
            .shadow(
                elevation = 15.dp, spotColor = Color(0xFF000000), ambientColor = Color(
                    0xFF000000
                ), shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp)
            )
            .background(
                color = Color(0xFFF0F0F0),
                shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp)
            ),
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.menu)
                },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = BlueTheme
                ),
            )
        }
    }
}


@SuppressLint("CoroutineCreationDuringComposition")
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun Route(
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val navController = rememberNavController()
    var canNavigate by remember { mutableStateOf(false) }
    val dataStore = DataStoreManager(LocalContext.current)

    GlobalScope.launch {
        dataStore.getToken.collect { token ->
            if (token != null) {
                MyDBContainer.ACCESS_TOKEN = token
            }
        }
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        bottomBar = {
            if (canNavigate) {
                BottomNavBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ListScreen.SplashScreen.name,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable(ListScreen.Home.name) {
                canNavigate = true
                val homeViewModel: HomeViewModel = viewModel()
                HomeView(
                    homeViewModel = homeViewModel,
                    dataStore = dataStore,
                    navController = navController
                )
            }

            composable(ListScreen.WeeklyTask.name) {
                canNavigate = true
                val weeklyTaskViewModel: WeeklyTaskViewModel = viewModel()
            }

            composable(ListScreen.Category.name) {
                canNavigate = true
                val categoryViewModel: CategoryViewModel = viewModel()
                ViewCategory(categoryViewModel = categoryViewModel, navController = navController)
            }

            composable(ListScreen.FormCreate.name) {
                canNavigate = true
                val formCreateViewModel: FormCreateViewModel = viewModel()
            }

            composable(ListScreen.FormEdit.name) {
                canNavigate = true
            }

            composable(ListScreen.SplashScreen.name) {
                canNavigate = false
                SplashScreenView(navController = navController)
            }

            composable(ListScreen.SignIn.name) {
                if (MyDBContainer.ACCESS_TOKEN.isEmpty() || MyDBContainer.USER_ID == -1) {
                    canNavigate = false
                    val signInViewModel: SignInViewModel = viewModel()
                    SignInView(
                        navController = navController,
                        signInViewModel = signInViewModel,
                        dataStore = dataStore
                    )
                } else {
                    navController.navigate(ListScreen.Home.name) {
                        popUpTo(ListScreen.SignIn.name) { inclusive = true }
                    }
//                    val signInViewModel: SignInViewModel = viewModel()
//                    SignInView(
//                        navController = navController,
//                        signInViewModel = signInViewModel,
//                        dataStore = dataStore
//                    )
                }
            }

            composable(ListScreen.SignUp.name) {
                canNavigate = false
                val signUpViewModel: SignUpViewModel = viewModel()
                SignUpView(
                    navController = navController,
                    signUpViewModel = signUpViewModel,
                    dataStore = dataStore
                )
            }

            composable(ListScreen.EditProfile.name) {
                canNavigate = true
                EditProfileView(navController = navController)
            }

            composable(ListScreen.Authentication.name) {
                AuthenticationView(navController = navController)
            }


        }

    }
}

