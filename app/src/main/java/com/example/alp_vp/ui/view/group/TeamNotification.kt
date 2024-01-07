package com.example.alp_vp.ui.view.group

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun NotifikasiTeam(){

    Column(
        modifier = Modifier
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 10.dp, end = 20.dp, bottom = 50.dp)
        ) {

            IconButton(onClick = { /* logics */ }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "back")
            }
            Text(
                text = "Accept The Invitation",
                fontSize = 20.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, top = 10.dp)
            )

        }
        //lazyColumn
        NotifCard()

    }

}

@Composable
fun NotifCard(){
    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            Column {
                Text(
                    text = "Team Kerja VisProg",
                    fontFamily = poppins,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 5.dp, bottom = 2.dp, end = 16.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Made by Jerry",
                    fontFamily = poppins,
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 2.dp, end = 16.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            Row (modifier = Modifier.align(Alignment.CenterVertically)){
                Button(
                    onClick = {
                        // logics
                    },
                    modifier = Modifier.size(width = 65.dp, height = 40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                ) {
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription = "decline invitation",
                        modifier = Modifier.size(24.dp))
                }

                Button(
                    onClick = {
                        // logics
                    },
                    modifier = Modifier.size(width = 65.dp, height = 40.dp).padding(start=4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF22D3EE)),
                ) {
                    Icon(imageVector = Icons.Default.Check,
                        contentDescription = "accept invitation",
                        modifier = Modifier.size(24.dp))
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NotifikasiTeamPreview() {
    NotifikasiTeam()
}