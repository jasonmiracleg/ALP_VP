package com.example.alp_vp.ui.view.to_do_list

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp_vp.R
import com.example.alp_vp.ui.component.oneWeekCard
import com.example.alp_vp.ui.component.todoListCard

@Composable
fun WeeklyTaskView(){
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
         oneWeekCard()
         LazyColumn{
             items(5){
                 todoListCard()
             }
         }
     }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeeklyTaskPreview(){
    WeeklyTaskView()
}