package com.example.alp_vp.ui.view.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.alp_vp.ui.theme.poppins

@Composable
fun ViewCategory() {
    Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)) {
        TopNavBar()
        Row(verticalAlignment = Alignment.Bottom) {
            Image(
                painter = painterResource(id = R.drawable.to_do_list),
                contentDescription = "To Do List Icon"
            )
            Text(
                text = "Task Categories",
                fontFamily = poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )
        }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(top = 30.dp)) {
            item { CategoryCard("Add new Category", true) }
            items(5) {
                CategoryCard("Add", false, Color.Blue)
            }
        }
    }
}

@Composable
fun CategoryCard(
    categoryName: String,
    isNewCategory: Boolean,
    colorBackground: Color = Color(0xFFEBEBEB)
) {
    Card(
        colors = CardDefaults.cardColors(colorBackground),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(40)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Column(
                modifier = Modifier
                    .weight(0.8f)
            ) {
                Text(
                    text = categoryName,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = poppins,
                    fontSize = 18.sp,
                    color =
                    if (isNewCategory) {
                        Color.Black
                    } else {
                        Color.White
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Column {
                Icon(
                    imageVector = if (isNewCategory) {
                        Icons.Outlined.Add
                    } else {
                        Icons.Outlined.KeyboardArrowRight
                    },
                    contentDescription = "Action",
                    tint = if (isNewCategory) {
                        Color.Black
                    } else {
                        Color.White
                    },
                    modifier = Modifier.size(45.dp)
                )
            }
        }
    }
}

@Composable
fun TopNavBar() {
    Row {
        Column(modifier = Modifier.weight(0.8f)) {

        }
        Column {
            Icon(imageVector = Icons.Outlined.Settings, contentDescription = "Setting")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCategory() {
    ViewCategory()
}