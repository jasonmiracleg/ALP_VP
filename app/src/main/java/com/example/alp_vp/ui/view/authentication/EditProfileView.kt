package com.example.alp_vp.ui.view.authentication

import android.inputmethodservice.Keyboard
import android.os.Build
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp_vp.R
import com.example.alp_vp.ui.theme.poppins
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import androidx.compose.material.Divider



@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditProfileView() {

    var email by rememberSaveable {
        mutableStateOf("jerry@gmail.com")
    }
    var username by rememberSaveable {
        mutableStateOf("JerryNiBos")
    }
    var password by rememberSaveable {
        mutableStateOf("12345678")
    }
    var passwordVisibility by rememberSaveable {
        mutableStateOf(false)
    }
    var isClicked by rememberSaveable {
        mutableStateOf(false)
    }
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Instant.now().toEpochMilli()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }

            Text(
                text = "Edit Profile",
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                fontSize = 18.sp
            )

            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
            }

        }

        Spacer(modifier = Modifier.padding(bottom = 20.dp))

        Box(
            modifier = Modifier
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(50.dp)
                )
                .size(100.dp),
            contentAlignment = Alignment.Center
        ) {

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .background(Color(0x38BDF8))
                    .size(50.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.visibility),
                    contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        Text(
            text = "Jerry Tri Tjahyono",
            fontWeight = FontWeight.Bold,
            fontFamily = poppins,
            color = Color.Gray,
            fontSize = 22.sp,
            modifier = Modifier
                .padding(bottom = 20.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Text(
                text = "Email Address",
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                color = Color.LightGray,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 14.dp)
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF38BDF8),
                    unfocusedBorderColor = Color.LightGray,
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )

            Spacer(modifier = Modifier.padding(bottom = 16.dp))

            Text(
                text = "Username",
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                color = Color.LightGray,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 14.dp)
            )

            TextField(
                value = username,
                onValueChange = { username = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF38BDF8),
                    unfocusedBorderColor = Color.LightGray,
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )

            Spacer(modifier = Modifier.padding(bottom = 16.dp))

            Text(
                text = "Password",
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                color = Color.LightGray,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 14.dp)
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = if (passwordVisibility) KeyboardType.Text else KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF38BDF8),
                    unfocusedBorderColor = Color.LightGray,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                trailingIcon = {

                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            painter = if (passwordVisibility) painterResource(id = R.drawable.visibility) else painterResource(
                                id = R.drawable.visibilityoff
                            ),
                            contentDescription = "Visibility Icon",
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp)
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.padding(bottom = 16.dp))

            Text(
                text = "Confirm Password",
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                color = Color.LightGray,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 14.dp)
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = if (passwordVisibility) KeyboardType.Text else KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF38BDF8),
                    unfocusedBorderColor = Color.LightGray,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                trailingIcon = {

                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            painter = if (passwordVisibility) painterResource(id = R.drawable.visibility) else painterResource(
                                id = R.drawable.visibilityoff
                            ),
                            contentDescription = "Visibility Icon",
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp)
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.padding(bottom = 16.dp))

            Text(
                text = "Born Date",
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                color = Color.LightGray,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 14.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,

                )
            {

                Text(
                    text = datePickerState.selectedDateMillis.changeToStringg(),
                    fontFamily = poppins,
                    modifier = Modifier.padding(start = 12.dp),
                )

                IconButton(
                    onClick = {
                        isClicked = !isClicked
                    }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "",
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                    )
                }
            }

            Divider(
                color = Color.LightGray, thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            BornDatePicked(
                state = datePickerState,
                isOpen = isClicked,
                onDismissRequest = { isClicked = false },
                onConfirmButtonClicked = { isClicked = false }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Joined 30 August 2023",
                    fontFamily = poppins,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 14.dp)
                )
                
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF38BDF8),
                    ),
                    modifier = Modifier
                        .shadow(
                            elevation = 14.dp,
                            spotColor = Color(0x33FF8D4D),
                            ambientColor = Color(0x33FF8D4D)
                        )
                        .height(40.dp)
                ) {

                    Text(
                        text = "Save",
                        style = TextStyle(
                            fontFamily = poppins,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }

        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BornDatePicked(
    state: DatePickerState,
    isOpen: Boolean,
    confirmButtonText: String = "OK",
    dismissButtonText: String = "Cancel",
    onDismissRequest: () -> Unit,
    onConfirmButtonClicked: () -> Unit
) {
    if (isOpen) {
        DatePickerDialog(
            onDismissRequest = onDismissRequest,
            confirmButton = {
                TextButton(
                    onClick = onConfirmButtonClicked
                ) {
                    Text(
                        text = confirmButtonText
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismissRequest
                ) {
                    Text(
                        text = dismissButtonText
                    )
                }
            },
            content = {
                DatePicker(
                    state = state
                )
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun Long?.changeToStringg(): String {
    val date: LocalDate = this?.let {
        Instant
            .ofEpochMilli(it)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
    } ?: LocalDate.now()
    return date.format(DateTimeFormatter.ofPattern("dd MM yyyy"))
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun EditProfilePreview() {
    return EditProfileView()
}