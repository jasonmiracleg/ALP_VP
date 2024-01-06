package com.example.alp_vp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alp_vp.viewmodel.to_do_list.FormCreateViewModel
import com.example.alp_vp.viewmodel.to_do_list.HomeViewModel
import com.example.alp_vp.viewmodel.to_do_list.WeeklyTaskViewModel

enum class ListScreen(){
    Home,
    WeeklyTask,
    FormCreate,
    FormEdit
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoListRoute(){
    val navController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ListScreen.Home.name,
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
        }

    }
}

