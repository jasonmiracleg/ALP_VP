package com.example.alp_vp.ui.view.to_do_list

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp_vp.R
import com.example.alp_vp.ui.theme.biru
import com.example.alp_vp.ui.theme.merah
import com.example.alp_vp.ui.theme.poppins

private val biruMuda = Color(0xFF41BBF1)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormEditView(){
    var title by remember { mutableStateOf("")}
    var hourse by remember { mutableStateOf("")}
    var minutes by remember { mutableStateOf("")}
    var seconds by remember { mutableStateOf("")}
    var reminder by remember { mutableStateOf("")}
    var description by remember { mutableStateOf("")}
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = {
            Column {
                Row(
                    modifier = Modifier
                        .background(biruMuda, shape = RectangleShape)
                        .fillMaxWidth(),
                    Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(20.dp, 30.dp)
                            .background(Color.White, CircleShape)
                            .padding(horizontal = 7.dp, vertical = 4.dp)
                    )
                    Text(
                        text = "Your Task",
                        modifier = Modifier
                            .padding(vertical = 30.dp),
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = poppins,
                        fontWeight = FontWeight.Bold

                    )
                    Image(
                        painter = painterResource(id = R.drawable.icons_add_task),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(20.dp, 30.dp)
                            .size(130.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                ) {
                    Text(
                        text = "Title",
                        fontFamily = poppins,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(top = 23.dp, bottom = 10.dp),
                        fontWeight = FontWeight.Bold
                    )
                    TextField(
                        value = title,
                        onValueChanged = { title = it },
                        placeholder = "beli tomat",
                        keyboardOptions =
                        KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .background(
                                color = Color(0xFFC9EFFF),
                                shape = RoundedCornerShape(size = 20.dp)
                            )
                            .fillMaxWidth()
                    )
                    Text(
                        text = "Category",
                        fontFamily = poppins,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(vertical = 7.dp),
                        fontWeight = FontWeight.Bold
                    )

                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 85.dp)
                    ) {
                        item {
                            Text(
                                text = "Group",
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
                                    .background(merah, shape = CircleShape)
                                    .padding(5.dp)
                                    .height(20.dp),
                                color = Color.White,
                                fontFamily = poppins,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        item {
                            Text(
                                text = "Urgent",
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
                                    .background(biru, shape = CircleShape)
                                    .padding(5.dp)
                                    .height(20.dp),
                                color = Color.White,
                                fontFamily = poppins,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            ) }
                        item {
                            Text(
                                text = "Project",
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
                                    .background(
                                        color = Color(0xFFD9D9D9),
                                        shape = CircleShape
                                    )
                                    .padding(5.dp)
                                    .height(20.dp),
                                color = Color.White,
                                fontFamily = poppins,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        item {
                            Text(
                                text = "Important",
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
                                    .background(
                                        color = Color(0xFFD9D9D9),
                                        shape = CircleShape
                                    )
                                    .padding(5.dp)
                                    .height(20.dp),
                                color = Color.White,
                                fontFamily = poppins,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        item {
                            Text(
                                text = "Fast",
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
                                    .background(
                                        color = Color(0xFFD9D9D9),
                                        shape = CircleShape
                                    )
                                    .padding(5.dp)
                                    .height(20.dp),
                                color = Color.White,
                                fontFamily = poppins,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        item {
                            Text(
                                text = "Routine",
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
                                    .background(
                                        color = Color(0xFFD9D9D9),
                                        shape = CircleShape
                                    )
                                    .padding(5.dp)
                                    .height(20.dp),
                                color = Color.White,
                                fontFamily = poppins,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        item {
                            Text(
                                text = "Individual",
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
                                    .background(
                                        color = Color(0xFFD9D9D9),
                                        shape = CircleShape
                                    )
                                    .padding(5.dp)
                                    .height(20.dp),
                                color = Color.White,
                                fontFamily = poppins,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        item {
                            Text(
                                text = "Today",
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
                                    .background(
                                        color = Color(0xFFD9D9D9),
                                        shape = CircleShape
                                    )
                                    .padding(5.dp)
                                    .height(20.dp),
                                color = Color.White,
                                fontFamily = poppins,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        item {
                            Text(
                                text = "Tomorrow",
                                modifier = Modifier
                                    .padding(top = 4.dp, bottom = 4.dp, end = 8.dp)
                                    .background(
                                        color = Color(0xFFD9D9D9),
                                        shape = CircleShape
                                    )
                                    .padding(5.dp)
                                    .height(20.dp),
                                color = Color.White,
                                fontFamily = poppins,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Text(
                        text = "Timer",
                        fontFamily = poppins,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(vertical = 7.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = hourse,
                            onValueChanged = { hourse = it },
                            placeholder = "Hours",
                            keyboardOptions =
                            KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .border(
                                    width = 1.6.dp,
                                    color = Color(0xFFCECECE),
                                    shape = RoundedCornerShape(size = 20.dp)
                                )
                                .width(80.dp)
                                .height(50.dp)
                        )

                        Text(
                            text = ":",
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(horizontal = 5.dp),
                            fontWeight = FontWeight.Bold
                        )

                        TextField(
                            value = minutes,
                            onValueChanged = { minutes = it },
                            placeholder = "Minutes",
                            keyboardOptions =
                            KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .border(
                                    width = 1.6.dp,
                                    color = Color(0xFFCECECE),
                                    shape = RoundedCornerShape(size = 20.dp)
                                )
                                .width(100.dp)
                                .height(50.dp)

                        )
                        Text(
                            text = ":",
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(horizontal = 5.dp),
                            fontWeight = FontWeight.Bold
                        )

                        TextField(
                            value = seconds,
                            onValueChanged = { seconds = it },
                            placeholder = "Seconds",
                            keyboardOptions =
                            KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .border(
                                    width = 1.6.dp,
                                    color = Color(0xFFCECECE),
                                    shape = RoundedCornerShape(size = 20.dp)
                                )
                                .width(105.dp)
                                .height(50.dp)
                        )

                    }

                    Text(
                        text = "Reminder",
                        fontFamily = poppins,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(vertical = 7.dp),
                        fontWeight = FontWeight.Bold
                    )
                    TextField(
                        value = reminder,
                        onValueChanged = { reminder = it },
                        placeholder = "Reminder",
                        keyboardOptions =
                        KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .border(
                                width = 1.6.dp,
                                color = Color(0xFFCECECE),
                                shape = RoundedCornerShape(size = 20.dp)
                            )
                            .width(110.dp)
                            .height(50.dp)
                    )


                    Text(
                        text = "Description",
                        fontFamily = poppins,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(vertical = 7.dp),
                        fontWeight = FontWeight.Bold
                    )

                    TextField(
                        value = description,
                        onValueChanged = { description = it },
                        placeholder = "add notes",
                        keyboardOptions =
                        KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .background(
                                color = Color(0xFFC9EFFF),
                                shape = RoundedCornerShape(size = 20.dp)
                            )
                            .fillMaxWidth()
                            .height(170.dp)
                    )

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .align(CenterHorizontally)
                            .height(41.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = biruMuda,)
                    ) {
                        Text(
                            text = "Save",
                            color = Color.White,
                            fontFamily = poppins,
                        )
                    }
                }
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    placeholder: String

){
    TextField(
        value = value,
        onValueChange = onValueChanged,
        keyboardOptions = keyboardOptions,
        modifier = modifier,
        placeholder = {
            Text(
                text = placeholder,
                fontFamily = poppins,
                color = Color.Gray,
            )},
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

            )
    )

}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FormEditPriview(){
    FormEditView()
}