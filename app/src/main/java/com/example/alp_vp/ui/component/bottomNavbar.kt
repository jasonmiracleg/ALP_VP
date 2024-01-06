package com.example.alp_vp.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.GroupAdd
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavbar() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                Modifier
                    .shadow(elevation = 15.dp, spotColor = Color(0xFF000000), ambientColor = Color(
                        0xFF000000
                    ),shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp))
                    .background(color = Color(0xFFF8F8F8), shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp)),
                containerColor = Color.Transparent
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 35.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    repeat(4) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(imageVector = getIcon(it), contentDescription = null)
                            Spacer(modifier = Modifier.height(2.dp)) // Adjust vertical spacing as needed
                            Text(text = getText(it))
                        }
                    }
                }
            }
        }
    ) {
        // Content of the screen
    }
}

private fun getIcon(index: Int): ImageVector = when (index) {
    0 -> Icons.Outlined.Home
    1 -> Icons.Outlined.CalendarMonth
    2 -> Icons.Outlined.GroupAdd
    3 -> Icons.Outlined.Category
    else -> throw IllegalArgumentException("Invalid index")
}

private fun getText(index: Int): String = when (index) {
    0 -> "Home"
    1 -> "Weekly"
    2 -> "Group"
    3 -> "Urgency"
    else -> throw IllegalArgumentException("Invalid index")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BottomNavbarPreview(){
    BottomNavbar()
}



