package com.example.alp_vp.ui.view.authentication

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.alp_vp.R
import com.example.alp_vp.ui.ListScreen
import com.example.alp_vp.ui.theme.poppins

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AuthenticationView(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(horizontal = 28.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        Image(
            painter = painterResource(id = R.drawable.authentication_illustration),
            contentDescription = null,
            modifier = Modifier
                .width(400.dp)
                .height(350.dp)
        )

        Text(
            text = "Get Things Done, Simply",
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF323232),
                textAlign = TextAlign.Center,
            ),
        )

        Spacer(Modifier.padding(bottom = 4.dp))

        Text(
            text = "\"Stay organized and never miss a task with our customizable to-do list app.\"",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                color = Color(0xFFB6B6B6),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(Modifier.padding(bottom = 12.dp))

        Button(
            onClick = { navController.navigate( ListScreen.SignIn.name) },
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
                .height(72.dp)
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

        Spacer(Modifier.padding(bottom = 18.dp))

        Button(
            onClick = { navController.navigate(ListScreen.SignUp.name) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
            ),
            border = BorderStroke(1.dp, Color(0xFF38BDF8)),
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
        ) {
            Text(
                text = "Sign Up",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF38BDF8),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuthenticationPreview() {
//    return AuthenticationView(navController = rememberNavController())
}