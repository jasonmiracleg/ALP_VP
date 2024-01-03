package com.example.alp_vp.ui.view.to_do_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alp_vp.R
import com.example.alp_vp.model.ToDoList
import com.example.alp_vp.model.isComplete
import com.example.alp_vp.model.isGroup
import com.example.alp_vp.ui.theme.BlueTheme
import com.example.alp_vp.ui.theme.poppins
import com.example.alp_vp.viewmodel.to_do_list.TimerViewModel
import java.sql.Time


@Composable
fun ViewTimer (timerViewModel: TimerViewModel = viewModel()) {
    val timerUIState by timerViewModel.data.collectAsState()
    var isPlayed by rememberSaveable { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp)
    ) {
        TopBar()
        Image(
            painter = painterResource(id = R.drawable.timer),
            contentDescription = "Timer Icon",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 128.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hour",
                fontFamily = poppins,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(0.2f),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Minute",
                fontFamily = poppins,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(0.2f),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Second",
                fontFamily = poppins,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(0.2f),
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = timerUIState.timerHours.toString().padStart(2, '0'),
                fontFamily = FontFamily.Monospace,
                fontSize = 40.sp,
                modifier = Modifier.weight(0.1f),
                textAlign = TextAlign.Center
            )
            Text(
                text = ":",
                fontFamily = FontFamily.Monospace,
                fontSize = 40.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = timerUIState.timerMinutes.toString().padStart(2, '0'),
                fontFamily = FontFamily.Monospace,
                fontSize = 40.sp,
                modifier = Modifier.weight(0.05f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = ":",
                fontFamily = FontFamily.Monospace,
                fontSize = 40.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = timerUIState.timerSeconds.toString().padStart(2, '0'),
                fontFamily = FontFamily.Monospace,
                fontSize = 40.sp,
                modifier = Modifier.weight(0.1f),
                textAlign = TextAlign.Center
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 120.dp)
        ) {
            Button(
                onClick = { /*TODO*/ }, shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    BlueTheme
                )
            ) {
                Icon(
                    imageVector = Icons.Outlined.Check,
                    contentDescription = "Done",
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .size(40.dp),
                    tint = Color.White
                )
            }
            Button(
                onClick = {
                    isPlayed = !isPlayed
                    timerViewModel.toggleTimer()
                }, shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    BlueTheme
                )
            ) {
                Icon(
                    painter =
                    if (!isPlayed) {
                        painterResource(id = R.drawable.baseline_play_circle_outline_24)
                    } else {
                        painterResource(id = R.drawable.baseline_pause_circle_outline_24)
                    },
                    contentDescription = if (!isPlayed) "Play" else "Pause",
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .size(40.dp)
                )
            }
        }
    }
}

@Composable
fun TopBar() {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowLeft,
            contentDescription = "Back",
            modifier = Modifier.size(38.dp)
        )
        Text(
            text = "Timer",
            fontFamily = poppins,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
        )
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowLeft,
            contentDescription = "Back",
            modifier = Modifier.size(38.dp),
            tint = Color.Transparent
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTimer() {
    ViewTimer()
}
