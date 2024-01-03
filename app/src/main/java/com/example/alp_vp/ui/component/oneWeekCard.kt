package com.example.alp_vp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.example.alp_vp.model.ToDoListWeekly
import com.example.alp_vp.ui.theme.poppins
import com.example.alp_vp.viewmodel.to_do_list.HomeViewModel
import com.example.alp_vp.viewmodel.to_do_list.WeeklyTaskViewModel

@Composable
fun oneWeekCard(
    weeklyTaskViewModel: WeeklyTaskViewModel = viewModel(),
    toDoListWeekly: ToDoListWeekly
){
    val weeklyTaskViewModel by weeklyTaskViewModel.uiState.collectAsState()
    var isclick by rememberSaveable { mutableStateOf(false) }

                    if (!isclick) {
                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = 5.dp,
                                    spotColor = Color(0xFF0F0F0F),
                                    ambientColor = Color(0x40000000),
                                    shape = RoundedCornerShape(5.dp, 15.dp, 5.dp, 15.dp)
                                )
                                .width(46.dp)
                                .height(44.dp)
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(5.dp, 15.dp, 5.dp, 15.dp)
                                )
                                .clickable {
                                    isclick = true;
                                }


                        ) {
                            Text(
                                text = toDoListWeekly.day,
                                fontSize = 14.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight(600),
                                color = Color(0xFF2C2B2B),
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = 5.dp,
                                    spotColor = Color(0xFF0F0F0F),
                                    ambientColor = Color(0x40000000),
                                    shape = RoundedCornerShape(5.dp, 15.dp, 5.dp, 15.dp)
                                )
                                .width(46.dp)
                                .height(44.dp)
                                .background(
                                    color = Color(0xFF38BDF8),
                                    shape = RoundedCornerShape(5.dp, 15.dp, 5.dp, 15.dp)
                                )
                                .clickable {
                                    isclick = true;
                                }


                        ) {
                            Text(
                                text = toDoListWeekly.day,
                                fontSize = 14.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight(600),
                                color = Color(0xFF2C2B2B),
                                modifier = Modifier
                                    .align(Alignment.Center)
                            )
                        }
    }
}