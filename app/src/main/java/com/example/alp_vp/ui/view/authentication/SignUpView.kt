package com.example.alp_vp.ui.view.authentication

import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.alp_vp.data.DataStoreManager
import com.example.alp_vp.ui.ListScreen
import com.example.alp_vp.viewmodel.authentication.SignUpViewModel
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpView(
    signUpViewModel: SignUpViewModel,
    navController: NavController,
    dataStore : DataStoreManager
) {
    var check by rememberSaveable {
        mutableStateOf(false)
    }
    var name by rememberSaveable {
        mutableStateOf("")
    }
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisibility by rememberSaveable {
        mutableStateOf(false)
    }
    var isClicked by rememberSaveable {
        mutableStateOf(false)
    }
    var bornDate by rememberSaveable {
        mutableStateOf("")
    }
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Instant.now().toEpochMilli()
    )
    var imageUri by rememberSaveable {
        mutableStateOf("")
    }
    val painter = rememberAsyncImagePainter(
        imageUri.ifEmpty {
            R.drawable.profile
        }
    )
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { imageUri = it.toString() }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 28.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Box {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(120.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = CircleShape
                        )
                )

            }
            Box(
                modifier = Modifier
                    .padding(
                        top = 86.dp,
                        start = 190.dp
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            launcher.launch("image/*")
                        }
                )
            }
        }

        Spacer(modifier = Modifier.padding(bottom = 10.dp))

        Text(
            text = "Sign Up",
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF323232),
            ),
        )

        Spacer(Modifier.padding(bottom = 4.dp))

        Text(
            text = "Get started your productivity today with sign up a new account",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                color = Color(0xFFB6B6B6),
            ),
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF38BDF8),
                unfocusedBorderColor = Color.LightGray,
            ),
            label = {
                Text(
                    text = "Name",
                    color = Color.Gray,
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF38BDF8),
                unfocusedBorderColor = Color.LightGray,
            ),
            label = {
                Text(
                    text = "Email",
                    color = Color.Gray,
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF38BDF8),
                unfocusedBorderColor = Color.LightGray,
            ),
            label = {
                Text(
                    text = "Password",
                    color = Color.Gray
                )
            },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth(),
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
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(bottom = 24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(1.dp, Color.LightGray, shape = RoundedCornerShape(16.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {

            Text(
                text = datePickerState.selectedDateMillis.changeToString(),
                fontFamily = poppins,
                color = Color.Gray,
                modifier = Modifier.padding(start = 12.dp),
                fontSize = 16.sp,
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

        BornDatePicker(
            state = datePickerState,
            isOpen = isClicked,
            onDismissRequest = { isClicked = false },
            onConfirmButtonClicked = { isClicked = false }
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        Button(
            onClick = {
                signUpViewModel.fillUserData(
                    name,
                    email,
                    password,
                    datePickerState.selectedDateMillis.changeToString(),
                    navController
                )
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF38BDF8),
            ),
            modifier = Modifier
                .shadow(
                    elevation = 14.dp,
                    spotColor = Color(0x33FF8D4D),
                    ambientColor = Color(0x33FF8D4D)
                )
                .fillMaxWidth()
                .height(66.dp),
        ) {

            Text(
                text = "Sign Up",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already have an account? Login Now!",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF38BDF8),
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier.clickable { navController.navigate(ListScreen.SignIn.name) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BornDatePicker(
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
fun Long?.changeToString() : String {
    val date: LocalDate = this?.let{
        Instant
            .ofEpochMilli(it)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
    } ?: LocalDate.now()
    return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString()
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun SignUpPreview() {
//    return SignUpView(navController = rememberNavController())
}