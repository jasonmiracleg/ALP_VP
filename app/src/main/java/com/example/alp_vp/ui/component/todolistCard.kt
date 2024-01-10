package com.example.alp_vp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alp_vp.R
import com.example.alp_vp.model.ToDoListResponse
import com.example.alp_vp.ui.theme.poppins
import com.example.alp_vp.viewmodel.to_do_list.HomeViewModel
import java.sql.Time

@Composable
fun todoListCard(
    homeViewModel: HomeViewModel = viewModel(),
    data: ToDoListResponse
//    category: ArrayList<Category>
) {
//    val homeUiState by homeViewModel.uiState.collectAsState()
    var isChecked by rememberSaveable { mutableStateOf(false) }
//
    Box(
        modifier = Modifier
            .padding(20.dp, 8.dp)
            .shadow(
                elevation = 2.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000),
                shape = RoundedCornerShape(15.dp)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(15.dp))
            .padding(20.dp, 10.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.8f)
                ) {
                    Text(
                        text = data.title,
                        fontFamily = poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
//                    toDoListV2.description?.let {
//                        Text(
//                            text = it,
//                            fontFamily = poppins,
//                            modifier = Modifier,
//                            fontSize = 10.sp
//                        )
//                    }
                    LazyRow(
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
//                        items(
//                            category.size
//                        ){
//                            Text(
//                                text = category[it].category_title,
//                                modifier = Modifier
//                                    .padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
//                                    .background(
//                                        Color(android.graphics.Color.parseColor("#${category[it].color}")),
//                                        shape = CircleShape
//                                    )
//                                    .padding(5.dp)
//                                    .width(28.dp)
//                                    .height(12.dp),
//                                color = Color.White,
//                                fontFamily = poppins,
//                                fontSize = 8.sp
//                            )
                    }
                }
                if (isChecked) {
                    Icon(
                        painterResource(id = R.drawable.checkbox_selesai),
                        contentDescription = null,
                        modifier = Modifier
                            .size(45.dp)
                            .width(1.dp)
                            .clickable {
                                isChecked = false
//                            homeViewModel.updatetoDoList(data, isChecked)
                            },
                        tint = Color.Gray,
                    )
                } else {
                    Icon(
                        painterResource(id = R.drawable.checkbox_blank),
                        contentDescription = null,
                        modifier = Modifier
                            .size(45.dp)
                            .width(1.dp)
                            .clickable {
                                isChecked = true;
//                            homeViewModel.updatetoDoList(data, isChecked)
                            },
                        tint = Color.Gray,
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = false)
//@Composable
//fun PreviewTDL() {
//    todoListCard(
//        data = ToDoList(
//            "Coba Makan",
//            ArrayList(),
//            "",
//            isGroup.group,
//            isComplete.done,
//            Time.valueOf("12:15:00")
//        )
//    )
//}