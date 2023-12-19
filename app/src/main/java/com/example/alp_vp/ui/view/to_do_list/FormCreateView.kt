package com.example.alp_vp.ui.view.to_do_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp_vp.R
import com.example.alp_vp.ui.component.merah

private val biruMuda = Color(0xFF41BBF1)
@Composable
fun FormCreateView(){
    Column (

    ){
        Row (
            modifier = Modifier
                .background(biruMuda, shape = RectangleShape)
                .fillMaxWidth(),
            Arrangement.SpaceBetween
        ){
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .padding(20.dp, 30.dp)
                    .background(Color.White, CircleShape)
            )
            Text(
                text = "Your Task",
                modifier = Modifier
                .padding(vertical = 30.dp),
                fontSize = 20.sp,
                color = Color.White

            )
            Image(
                painter = painterResource(id = R.drawable.icons_add_task),
                contentDescription = null,
                modifier = Modifier
                    .padding(20.dp, 30.dp)
                    .size(100.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(30.dp,10.dp)
        ) {

            Text(text = "Title")
            CustomAnswer(
                value = "",
                onValueChanged = { },
                text = "Sks",
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(text = "Category")
            Box(
                modifier = Modifier
                    .background(merah, shape = RoundedCornerShape(15.dp))
            ){
                Text(text = "Urgent")
            }

            Text(text = "Date - time")

            CustomAnswer(
                value = "",
                onValueChanged = { },
                text = "Hours",
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
            CustomAnswer(
                value = "",
                onValueChanged = { },
                text = "Minutes",
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
            CustomAnswer(
                value = "",
                onValueChanged = { },
                text = "Second",
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
            Text(text = "Description")
            CustomAnswer(
                value = "",
                onValueChanged = { },
                text = "add notes",
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAnswer(
    value: String,
    onValueChanged: (String) -> Unit,
    text: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(text = text) },
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FormCreatePriview(){
    FormCreateView()
}