package com.example.alp_vp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp_vp.R
import com.example.alp_vp.model.Category
import com.example.alp_vp.model.ToDoList
import com.example.alp_vp.ui.theme.poppins

@Composable
fun todolistOneweekCard(
    toDoList: ToDoList,
    category: ArrayList<Category>
){
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
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            Arrangement.SpaceEvenly
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,

                ){
                Column (
                    modifier = Modifier
                        .weight(0.8f)
                ){
                    Text(
                        text = toDoList.title,
                        fontFamily = poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    toDoList.description?.let {
                        Text(
                            text = it,
                            fontFamily = poppins,
                            modifier = Modifier,
                            fontSize = 10.sp
                        )
                    }
                    LazyRow (
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        items(
                            category.size
                        ){
                            Text(
                                text = category[it].category_title,
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
                                    .background(
                                        Color(android.graphics.Color.parseColor("#${category[it].color}")),
                                        shape = CircleShape
                                    )
                                    .padding(5.dp)
                                    .width(28.dp)
                                    .height(12.dp),
                                color = Color.White,
                                fontFamily = poppins,
                                fontSize = 8.sp
                            )
                        }
                    }
                }
                Icon(
                    painterResource(id = R.drawable.edit),
                    contentDescription = null,
                    modifier = Modifier
                        .size(28.dp)
                        .width(1.dp),
                    tint = Color.Black
                    )
                Spacer(
                    modifier = Modifier
                        .padding(5.dp)
                )
                Icon(
                    painterResource (id = R.drawable.trash),
                    contentDescription = null,
                    modifier = Modifier
                        .size(29.dp)
                        .width(1.dp),
                    tint = Color.Red
                    )
            }
        }
    }
}