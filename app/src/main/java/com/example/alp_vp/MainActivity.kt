package com.example.alp_vp

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.TimePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.alp_vp.navigation.Navigation
import com.example.alp_vp.ui.theme.ALP_VPTheme
import com.example.alp_vp.ui.view.category.NotificationService
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Calendar

class MainActivity : ComponentActivity() {

    //    lateinit var navController: NavHostController
    @OptIn(ExperimentalPermissionsApi::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ALP_VPTheme {

                val notificationService = NotificationService(applicationContext)
                val coroutineScope = rememberCoroutineScope()

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        val permissionState =
                            rememberPermissionState(permission = android.Manifest.permission.POST_NOTIFICATIONS)
                        if (!permissionState.status.isGranted) {
                            Button(onClick = { permissionState.launchPermissionRequest() }) {
                                Text(
                                    text = "allow notification",
                                    fontSize = 22.sp
                                )
                            }
                        }

                    }

                    Spacer(modifier = Modifier.padding(bottom = 16.dp))

                    val calendar = Calendar.getInstance()
                    calendar.set(Calendar.HOUR_OF_DAY, 18)
                    calendar.set(Calendar.MINUTE, 0)
                    val timeDiff = calendar.timeInMillis - System.currentTimeMillis()

                    Button(
                        onClick = {
                            coroutineScope.launch {
                                delay(timeDiff)
                                notificationService.showNotification()
                            }
                        }
                    ) {
                        Text(
                            text = "show notification",
                            fontSize = 22.sp
                        )
                    }
                }

//                navController = rememberNavController()
//                Navigation(navController = navController)
            }
        }
    }
}