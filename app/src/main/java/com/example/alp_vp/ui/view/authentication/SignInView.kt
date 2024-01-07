package com.example.alp_vp.ui.view.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.alp_vp.R
import com.example.alp_vp.ui.theme.poppins
import com.example.alp_vp.viewmodel.authentication.SignInViewModel

@Composable
fun SignInView(
    navController: NavController,
    signInViewModel: SignInViewModel = viewModel()
) {

    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisibility by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 28.dp),
        verticalArrangement = Arrangement.Center
    ) {

//        Image(
//            painter = painterResource(id = R.drawable.sign_in_illustration),
//            contentDescription = null,
//            modifier = Modifier
//                .width(360.dp)
//                .height(284.dp)
//        )

        Text(
            text = "Sign In",
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF323232),
            ),
        )

        Spacer(Modifier.padding(bottom = 4.dp))

        Text(
            text = "Enter your username and password to continue",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                color = Color(0xFFB6B6B6),
            ),
        )

        Spacer(Modifier.padding(bottom = 12.dp))

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
                keyboardType = KeyboardType.Text,
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

//                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
//                    Icon(
//                        painter = if (passwordVisibility) painterResource(id = R.drawable.visibility) else painterResource(id = R.drawable.visibilityoff),
//                        contentDescription = "Visibility Icon",
//                        modifier = Modifier
//                            .height(24.dp)
//                            .width(24.dp)
//                    )
//                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()

        )

        Spacer(modifier = Modifier.padding(bottom = 24.dp))

        Button(
            enabled = email.isNotBlank() && password.isNotBlank(),
            onClick = { signInViewModel.logIn(email, password, navController) },
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
                .height(66.dp)
        ) {

            Text(
                text = "Sign In",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInPreview() {
    return SignInView(navController = rememberNavController())
}