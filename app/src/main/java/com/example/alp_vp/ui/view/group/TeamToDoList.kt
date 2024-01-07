package com.example.alp_vp.ui.view.group

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp_vp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamToDoList() {

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, top = 30.dp, end = 20.dp, bottom = 30.dp)
            ) {

                IconButton(onClick = { /* logics */ }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "back")
                }
                Text(
                    text = "Team Kerja VisProg",
                    fontSize = 20.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp, top = 10.dp)
                )

            }
        },
//        bottomBar = {
//            BottomAppBar(
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                contentColor = MaterialTheme.colorScheme.primary,
//            ) {
//                Text(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    textAlign = TextAlign.Center,
//                    text = "Bottom app bar",
//                )
//            }
//        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /**/ },

                containerColor = Color(android.graphics.Color.parseColor("#38BDF8")),
                shape = CircleShape,
                modifier = Modifier
                    .padding(all = 16.dp),


                ) {
                Icon(Icons.Filled.Add, "Small floating action button.", tint = Color.White)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //row untuk profile se-team
            Row {
                Image(
                    painter = painterResource(id = R.drawable.profilepict),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
            }

            Text(
                text = "Membuat aplikasi android management waktu",
                fontSize = 12.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 4.dp, bottom = 20.dp, top = 8.dp)
            )

            //lazyColumn
            ToDoListCard()

        }
    }
}



@Composable
fun ToDoListCard(){

    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .fillMaxWidth().padding(start = 20.dp, end = 20.dp, bottom = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Row (modifier = Modifier.padding(10.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.profilepict),
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(35.dp)
                            .clip(CircleShape)

                    )
                }

                Text(
                    text = "Deadline hari minggu, pukul 23.59",
                    fontFamily = poppins,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Text(
                    text = "Mengerjakan Figma",
                    fontFamily = poppins,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 6.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Row (modifier = Modifier.align(Alignment.CenterVertically)) {
                val checkedState = remember { mutableStateOf(true) }
                //var myState by remember { mutableStateOf(false) }
                Checkbox(
//                    checked = myState,
//                    onCheckedChange = { myState = it },
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(Color(0xFF22D3EE)),
                )
                IconButton(onClick = { /*logics*/ },
                    modifier = Modifier.align(Alignment.Top)) {
                    Icon(Icons.Default.MoreVert, "option")
                }
            }

        }
    }
}

//@Composable
//fun OptionToDoList(){
//    Row {
//        // Create a boolean variable
//        // to store the display menu state
//        var mDisplayMenu by remember { mutableStateOf(false) }
//        // fetching local context
//        val mContext = LocalContext.current
//
//        val checkedState = remember { mutableStateOf(true) }
//        //var myState by remember { mutableStateOf(false) }
//        Checkbox(
////                    checked = myState,
////                    onCheckedChange = { myState = it },
//            checked = checkedState.value,
//            onCheckedChange = { checkedState.value = it },
//            colors = CheckboxDefaults.colors(Color(0xFF22D3EE))
//        )
//
//        // Creating Icon button for dropdown menu
//        IconButton(onClick = { mDisplayMenu = !mDisplayMenu }) {
//            Icon(Icons.Default.MoreVert, "option")
//        }
//
//        // Creating a dropdown menu
//        DropdownMenu(
//            expanded = mDisplayMenu,
//            onDismissRequest = { mDisplayMenu = false }
//        ) {
//
//            // Creating dropdown menu item, on click
//            // would create a Toast message
//            DropdownMenuItem(onClick = { Toast.makeText(mContext, "Settings", Toast.LENGTH_SHORT).show() }) {
//                Text(text = "Settings")
//            }
//
//            // Creating dropdown menu item, on click
//            // would create a Toast message
//            DropdownMenuItem(onClick = { Toast.makeText(mContext, "Logout", Toast.LENGTH_SHORT).show() }) {
//                Text(text = "Logout")
//            }
//        }
//    }
//}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TeamToDoListPreview() {
    TeamToDoList()
}