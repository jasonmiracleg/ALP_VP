package com.example.alp_vp.ui.view.category

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.alp_vp.R
import com.example.alp_vp.ui.theme.BlueOutline
import com.example.alp_vp.ui.theme.ButtonColor
import com.example.alp_vp.ui.theme.poppins
import com.github.skydoves.colorpicker.compose.ColorPickerController
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.drawColorIndicator
import com.github.skydoves.colorpicker.compose.rememberColorPickerController

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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(top = 30.dp)
        ) {
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

@Composable
fun Popup() {
    val controller = rememberColorPickerController()


    Dialog(onDismissRequest = { /*TODO*/ }) {
        Card(
            colors = CardDefaults.cardColors(Color.White),
            border = BorderStroke(1.dp, color = Color.Black)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Add New Category",
                    fontFamily = poppins,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 22.sp
                )
                Text(
                    text = "Category title",
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = BlueOutline,
                        unfocusedContainerColor = BlueOutline,
                        disabledContainerColor = BlueOutline,
                        unfocusedBorderColor = Color.Transparent,
                    ),
                    placeholder = {
                        Text(
                            text = "ex. Habits",
                            fontFamily = poppins,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    shape = RoundedCornerShape(35),
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Chosen Color : ",
                        fontFamily = poppins,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                    Box(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(height = 40.dp, width = 100.dp)
                            .background(Color.Magenta)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.outline_colorize_24),
                        contentDescription = "Color Picker",
                        modifier = Modifier.size(30.dp)
                    )
                }
                ColorPicker(controller = controller)
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(ButtonColor)
                    ) {
                        Text(
                            text = "Add",
                            fontFamily = poppins,
                            modifier = Modifier.padding(horizontal = 12.dp),
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ColorPicker(controller: ColorPickerController){
    var hexCode by remember { mutableStateOf("") }
    var textColor by remember { mutableStateOf(Color.Transparent) }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
        HsvColorPicker(
            modifier = Modifier
                .size(150.dp)
                .padding(10.dp),
            controller = controller,
            drawOnPosSelected = {
                drawColorIndicator(
                    controller.selectedPoint.value,
                    controller.selectedColor.value,
                )
            },
            onColorChanged = { colorEnvelope ->
                hexCode = colorEnvelope.hexCode
                textColor = colorEnvelope.color
            },
            initialColor = Color.Red,
        )
    }
}

@Preview(showBackground = false, showSystemUi = false)
@Composable
fun PreviewCategory() {
    Popup()
}