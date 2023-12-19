package com.example.alp_vp.ui.view.group

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp_vp.R
import kotlin.math.pow
import androidx.compose.material3.Icon as Icon

val poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
)
@Composable
fun TeamListView(){
    Column(
        modifier = Modifier
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
        ) {
            Text(
                text = "Team List",
                fontSize = 20.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Notif"
            )
        }
        createTeam()
        Image(
            painter = painterResource(id = R.drawable.line),
            contentDescription = "divider",
            modifier = Modifier
                .fillMaxWidth()
                .size(20.dp)

        )
        //lazycolumn
        ListGroupCard()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun createTeam(){
    var searchusername by rememberSaveable { mutableStateOf("") }
    var team_description by rememberSaveable { mutableStateOf("") }
    Column (
        modifier = Modifier
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = "Create New Team",
            fontSize = 18.sp,
            fontFamily = poppins,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 4.dp, bottom = 20.dp, top = 4.dp)
        )
        //LazyRow(){} untuk profile picts users
        Row {
            Image(
                painter = painterResource(id = R.drawable.profilepict),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)

            )
        }
        CustomSearchUsernameField(
            value = searchusername,
            onValueChanged = {searchusername = it} ,
            text = "Search username...",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(vertical = 8.dp)

        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                

        ){
            CustomTeamDescriptionField(
                value = team_description,
                onValueChanged = {team_description = it} ,
                text = "Description Team",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .height(80.dp)
                    .weight(1f)
                    .padding(top = 8.dp, bottom = 8.dp)
            )
            Image(painter = painterResource(id = R.drawable.add_group),
                contentDescription = "tambah grup",
                modifier = Modifier
                    .size(80.dp)
                    .padding(12.dp)
            )

        }

    }
}


@Composable
fun ListGroupCard(colorBackground: Color = Color(0xFFEBEBEB)){
    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 50.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row {
            Column {
                Text(
                    text = "Team Kerja VisProg",
                    fontFamily = poppins,
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                )

            }
            Button(onClick={},colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF22D3EE),
            ),){
                Text(text="Open", fontFamily = poppins)
            }

        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchUsernameField(
    value: String,
    onValueChanged: (String) -> Unit,
    text: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,

) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        shape = RoundedCornerShape(50.dp),

        trailingIcon = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Username"
                )
            }
        },
        label = { Text(text = text, color = Color.Gray) },
        keyboardOptions = keyboardOptions,
        modifier = modifier.fillMaxWidth()
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTeamDescriptionField(
    value: String,
    onValueChanged: (String) -> Unit,
    text: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,

    ) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        shape = RoundedCornerShape(50.dp),
        label = { Text(text = text, color = Color.Gray) },
        keyboardOptions = keyboardOptions,
        modifier = modifier.fillMaxWidth()
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TeamListPreView(){
    TeamListView()
}

