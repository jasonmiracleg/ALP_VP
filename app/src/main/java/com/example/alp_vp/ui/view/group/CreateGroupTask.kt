package com.example.alp_vp.ui.view.group


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp_vp.R
import com.example.alp_vp.viewmodel.group.GroupTodolistViewModel

private val blue = Color(0xFF41BBF1)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateGroupTask(
    groupTodolistViewModel: GroupTodolistViewModel
) {
    var task_title by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    val options = listOf("Jerry", "Jason", "Yobel", "Marshanda")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    Scaffold(
        topBar = {
            Row (
                modifier = Modifier
                    .background(
                        blue,
                        shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
                    )
                    .fillMaxWidth(),
                Arrangement.SpaceBetween
            ){
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(20.dp, 30.dp),
                    tint = Color.White
                )
                Text(
                    text = "Your Task",
                    fontSize = 20.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .padding(vertical = 30.dp)
                        .align(Alignment.CenterVertically),
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.createform),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(20.dp, 30.dp)
                        .size(100.dp)
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { groupTodolistViewModel.addGroupTask(task_title, description) },

                containerColor = Color(android.graphics.Color.parseColor("#38BDF8")),
                modifier = Modifier
                    .padding(all = 20.dp)
                    .requiredWidth(width = 110.dp)
                    .requiredHeight(height = 40.dp),


                ) {
                Text(
                    text = "Save",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppins,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            //form
            //textfield for TITLE
            Text(
                text = "Title",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 19.sp),
                fontFamily = poppins,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 50.dp, start = 30.dp, bottom = 2.dp)
                )

            CustomTitleDesc(
                value = task_title,
                onValueChanged = {task_title = it} ,
                text = "Mengerjakan Figma",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .height(80.dp),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = poppins
                )
            )

            //textfield for DESC
            Text(
                text = "Description",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 19.sp),
                fontFamily = poppins,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 16.dp, start = 30.dp, bottom = 2.dp)
            )

            CustomTitleDesc(
                value = description,
                onValueChanged = {description = it} ,
                text = "Deadline hari minggu, pukul 23.59",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .height(120.dp),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = poppins
                )
            )

            //textfield for DropDown (person doing the task)
            Text(
                text = "The person doing the work",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 19.sp),
                fontFamily = poppins,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 16.dp, start = 30.dp, bottom = 2.dp)
            )
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },

            ) {
                val containerColor = Color(android.graphics.Color.parseColor("#C9EFFF"))
                TextField(
                    readOnly = true,
                    value = selectedOptionText,
                    onValueChange = { },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        disabledTextColor = Color.Transparent,
                        focusedContainerColor = containerColor,
                        unfocusedContainerColor = containerColor,
                        disabledContainerColor = containerColor,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ),
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(20.dp),
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = poppins,

                    )

                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),


                ) {
                    options.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = { Text(text = selectionOption) },
                            onClick = {
                                selectedOptionText = selectionOption
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTitleDesc(
    value: String,
    onValueChanged: (String) -> Unit,
    text: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    textStyle: TextStyle
    ) {
    val containerColor = Color(android.graphics.Color.parseColor("#C9EFFF"))
    TextField(
        value = value,
        onValueChange = onValueChanged,
        shape = RoundedCornerShape(20.dp),
        placeholder = { Text(text = text, color = Color.Gray) },
        keyboardOptions = keyboardOptions,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        colors = TextFieldDefaults.colors(
            disabledTextColor = Color.Transparent,
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
    )
}

@Composable
fun CreateGroupTaskWrapper() {
    val groupTodolistViewModel = GroupTodolistViewModel()

    CreateGroupTask(groupTodolistViewModel = groupTodolistViewModel)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreateGroupTaskPreview() {
    CreateGroupTaskWrapper()
}
