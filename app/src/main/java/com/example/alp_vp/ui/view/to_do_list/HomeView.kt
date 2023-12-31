package com.example.alp_vp.ui.view.to_do_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alp_vp.ui.component.todoListCard
import com.example.alp_vp.ui.theme.poppins
import com.example.alp_vp.viewmodel.to_do_list.HomeViewModel

@Composable
fun HomeView(
    homeViewModel: HomeViewModel = viewModel()
){
    val homeUiState by homeViewModel.uiState.collectAsState()

    Column {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(20.dp, 25.dp)
        ){
            Text(
                text = "Logo + Nama app",
                fontFamily = poppins
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp),
                tint = Color.Gray

            )
        }
        Text(
            text = "Hi " + homeUiState.user +" !",
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
        LazyColumn(
            modifier = Modifier
                .padding(vertical = 15.dp)
        ){
            items(homeUiState.todoList.size){
                todoListCard(HomeViewModel(),homeUiState.todoList[it],homeUiState.todoList[it].listCategory)
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview(){
    HomeView()
}