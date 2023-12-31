package com.example.alp_vp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alp_vp.ui.theme.ALP_VPTheme
import com.example.alp_vp.ui.view.to_do_list.FormCreateView
import com.example.alp_vp.ui.view.to_do_list.HomeView
import com.example.alp_vp.ui.view.to_do_list.WeeklyTaskPreview
import com.example.alp_vp.ui.view.to_do_list.WeeklyTaskView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ALP_VPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeeklyTaskView()
                }
            }
        }
    }
}