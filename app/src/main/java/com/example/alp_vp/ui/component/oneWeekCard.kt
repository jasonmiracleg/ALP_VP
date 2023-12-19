package com.example.alp_vp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp_vp.ui.theme.poppins

@Composable
fun oneWeekCard(){
    Box{
        Row (
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
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 20.dp))
                .padding(18.dp,18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 5.dp,
                        spotColor = Color(0xFF0F0F0F),
                        ambientColor = Color(0x40000000),
                        shape = RoundedCornerShape(5.dp, 15.dp,5.dp,15.dp)
                    )
                    .width(46.dp)
                    .height(44.dp)
                    .background(color = Color(0xFF38BDF8), shape = RoundedCornerShape(5.dp, 15.dp,5.dp,15.dp))

            ){
                Text(
                    text = "Mon",
                    fontSize = 14.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF2C2B2B),
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            Box(
                Modifier
                    .shadow(
                        elevation = 5.dp,
                        spotColor = Color(0xFF0F0F0F),
                        ambientColor = Color(0x40000000),
                        shape = RoundedCornerShape(5.dp, 15.dp,5.dp,15.dp)
                    )
                    .width(46.dp)
                    .height(44.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(5.dp, 15.dp,5.dp,15.dp))
            ){
                Text(
                    text = "Tue",
                    fontSize = 14.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF2C2B2B),
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            Box(
                Modifier
                    .shadow(
                        elevation = 5.dp,
                        spotColor = Color(0xFF0F0F0F),
                        ambientColor = Color(0x40000000),
                        shape = RoundedCornerShape(5.dp, 15.dp,5.dp,15.dp)
                    )
                    .width(46.dp)
                    .height(44.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(5.dp, 15.dp,5.dp,15.dp))

            ){
                Text(text = "Wed",
                    fontSize = 14.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF2C2B2B),
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            Box(
                Modifier
                    .shadow(
                        elevation = 5.dp,
                        spotColor = Color(0xFF0F0F0F),
                        ambientColor = Color(0x40000000),
                        shape = RoundedCornerShape(5.dp, 15.dp,5.dp,15.dp)
                    )
                    .width(46.dp)
                    .height(44.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(5.dp, 15.dp,5.dp,15.dp))

            ){
                Text(text = "Thur",
                    fontSize = 14.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF2C2B2B),
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            Box(
                Modifier
                    .shadow(
                        elevation = 5.dp,
                        spotColor = Color(0xFF0F0F0F),
                        ambientColor = Color(0x40000000),
                        shape = RoundedCornerShape(5.dp, 15.dp,5.dp,15.dp)
                    )
                    .width(46.dp)
                    .height(44.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(5.dp, 15.dp,5.dp,15.dp))

            ){
                Text(text = "Fri",
                    fontSize = 14.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF2C2B2B),
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            Box(
                Modifier
                    .shadow(
                        elevation = 5.dp,
                        spotColor = Color(0xFF0F0F0F),
                        ambientColor = Color(0x40000000),
                        shape = RoundedCornerShape(5.dp, 15.dp,5.dp,15.dp)
                    )
                    .width(46.dp)
                    .height(44.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(5.dp, 15.dp,5.dp,15.dp))

            ){
                Text(text = "Sat",
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
}