package com.example.alp_vp.ui.view.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.alp_vp.R
import com.example.alp_vp.ui.ListScreen
import kotlinx.coroutines.delay


@Composable
fun SplashScreenView(
    navController: NavController
)
{
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate(route = ListScreen.Authentication.name)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF38BDF8)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.logo_blue),
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    return SplashScreenView(navController = rememberNavController())
}