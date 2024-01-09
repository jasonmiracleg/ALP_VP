package com.example.alp_vp.ui.view.to_do_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.alp_vp.data.DataStoreManager
import com.example.alp_vp.model.APIListResponse
import com.example.alp_vp.model.Category
import com.example.alp_vp.model.ToDoListResponse
import com.example.alp_vp.model.ToDoListV2
import com.example.alp_vp.ui.ListScreen
import com.example.alp_vp.ui.component.todoListCard
import com.example.alp_vp.ui.theme.poppins
import com.example.alp_vp.viewmodel.category.CategoryUIState
import com.example.alp_vp.viewmodel.to_do_list.HomeUIState
import com.example.alp_vp.viewmodel.to_do_list.HomeViewModel
import retrofit2.Response


@Composable
fun HomeView(
    navController: NavController,
    dataStore : DataStoreManager,
    homeViewModel: HomeViewModel,
    ) {
//    val homeUiState by homeViewModel.uiState.collectAsState()

    val homeVM: HomeUIState = homeViewModel.homeuiState
    var allToDoListBody: Response<APIListResponse<List<ToDoListResponse>>>? = null
    var userId: Int? = null
    when (val status = homeViewModel.homeuiState) {

        is HomeUIState.Success -> {
//            userId = homeVM.user
//            allToDoListBody = homeVM.listToDO
        }

        is HomeUIState.Error -> {}

        HomeUIState.Loading -> {}

        else -> {}

    }

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(20.dp, 25.dp)
        ) {
            Text(
                text = "Logo + Nama app",
                fontFamily = poppins
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                modifier = Modifier.clickable {
                    navController.navigate(ListScreen.FormCreate.name)
                }
            )
            Icon(
                imageVector = Icons.Outlined.Logout,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        homeViewModel.logout(dataStore, navController)
                    },
                tint = Color.Gray

            )
        }
        Text(
            text = "Hi " + " !",
            modifier = Modifier
                .padding(horizontal = 20.dp),
            fontSize = 25.sp,
            fontFamily = poppins,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Ready to finish your task for today",
            modifier = Modifier
                .padding(horizontal = 20.dp),
            color = Color.Gray,
            fontSize = 16.sp,
            fontFamily = poppins,
            fontWeight = FontWeight.Bold
        )
//        Button(
//            onClick = { homeViewModel.getAllToDoList() }
//        ) {
//            Text("coba")
//        }
        LazyColumn(
            modifier = Modifier
                .padding(vertical = 15.dp)
        ) {
//            if (listData != null) {
//                items(listData.size) {
//                    todoListCard(
//                        homeViewModel = homeViewModel,
//                        data = listData[it]
////                                homeUiState.todoList[it],
////                        homeUiState.todoList[it].listCategory
//                    )
//                }
//            }
//            homeViewModel.getAllToDoList()?.let {
//                items(it) {
//                    todoListCard(
//                        homeViewModel,
//                        it
//                        homeUiState.todoList[it],
//                        homeUiState.todoList[it].listCategory
//                    )
//                }
        }
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HomePreview() {
////    HomeView()
//}