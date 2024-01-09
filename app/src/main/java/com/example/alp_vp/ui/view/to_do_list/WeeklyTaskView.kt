package com.example.alp_vp.ui.view.to_do_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alp_vp.R
import com.example.alp_vp.ui.component.oneWeekCard
import com.example.alp_vp.ui.component.todolistOneweekCard
import com.example.alp_vp.viewmodel.to_do_list.WeeklyTaskViewModel

@Composable
fun WeeklyTaskView(
    weeklyTaskViewModel: WeeklyTaskViewModel = viewModel()
){
     val weeklyTaskUiState by weeklyTaskViewModel.uiState.collectAsState()
     Column (
         horizontalAlignment = Alignment.CenterHorizontally,
         modifier = Modifier
             .padding(10.dp, 25.dp)
     ){
         Row {
             Text(
                 text = "Weekly Task",
                 fontSize = 15.sp,
                 fontWeight = FontWeight.Bold
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
         Image(
             painter = painterResource(id = R.drawable.gambar_weeklytask),
             contentDescription = null,
             modifier = Modifier
                 .padding(vertical = 14.dp)
         )

         Box (
             modifier = Modifier
                 .shadow(
                     elevation = 4.dp,
                     spotColor = Color(0x40000000),
                     ambientColor = Color(0x40000000),
                     shape = RoundedCornerShape(size = 20.dp)
                 )
                 .padding(1.dp)
                 .width(405.dp)
                 .height(100.dp)
                 .background(
                     color = Color(0xFFFFFFFF),
                     shape = RoundedCornerShape(size = 20.dp)
                 )
                 .padding(18.dp, 18.dp),
             contentAlignment = Alignment.CenterStart
         ){
                 LazyRow (
                     horizontalArrangement = Arrangement.spacedBy(11.dp)
                 ){
                     items(weeklyTaskUiState.listDay.size) {
                         oneWeekCard(WeeklyTaskViewModel(), weeklyTaskUiState.listDay[it])
                     }
                 }
             }

         LazyColumn{
             items(weeklyTaskUiState.listDay[0].todoList.size){
                 todolistOneweekCard(weeklyTaskUiState.listDay[0].todoList[it],weeklyTaskUiState.listDay[0].todoList[it].listCategory)
             }
         }
     }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeeklyTaskPreview(){
    WeeklyTaskView()
}