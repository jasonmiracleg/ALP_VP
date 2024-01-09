package com.example.alp_vp.ui.view.group

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alp_vp.R
import com.example.alp_vp.viewmodel.group.GroupViewModel
import androidx.compose.material3.Icon as Icon

val poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
)
@Composable
fun TeamListView(groupViewModel: GroupViewModel = viewModel()){
    val groupUIState by groupViewModel.data.collectAsState()
    Column(
        modifier = Modifier
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 10.dp, end = 20.dp)
        ) {
            Text(
                text = "Team List",
                fontSize = 20.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.weight(1f).align(Alignment.CenterVertically)
            )
            IconButton(onClick = { /*route(team_notif)*/ } ,
                modifier = Modifier.align(Alignment.Top)) {
                Icon(Icons.Outlined.Notifications, "notif")

            }
        }
        createTeam(groupViewModel)
        Image(
            painter = painterResource(id = R.drawable.line),
            contentDescription = "divider",
            modifier = Modifier
                .fillMaxWidth()
                .size(20.dp)

        )
        //lazycolumn
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),

        ){
            items(groupUIState.groups.size){
                ListGroupCard(
                    group_name = groupUIState.groups[it].group_name,
                    onClick = {
                        // Define your onClick logic here
                    },
                    onDeleteClick = {
                        groupViewModel.deleteGroup(groupUIState.groups[it])
                    }
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun createTeam(
    groupViewModel: GroupViewModel
){

    var searchusername by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var group_name by rememberSaveable { mutableStateOf("") }
    Column (
        modifier = Modifier
            .padding(16.dp),
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
                .padding(start = 4.dp, bottom = 4.dp)
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
                .height(80.dp)
                .padding(vertical = 8.dp)

        )
        CustomGroupName(
            value = group_name,
            onValueChanged = {group_name = it} ,
            text = "Group Name",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(vertical = 8.dp)

        )
        Row (
            modifier = Modifier
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                

        ){
            CustomTeamDescriptionField(
                value = description,
                onValueChanged = {description = it} ,
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
            Image(
                modifier = Modifier
                    .clickable { groupViewModel.addGroup(group_name, description) }
                    .size(60.dp),
                painter = painterResource(id = R.drawable.add_group),
                contentDescription = "Tambah group",
                alignment = Alignment.Center
            )


        }

    }
}


@Composable
fun ListGroupCard(
    colorBackground: Color = Color(0xFFEBEBEB),
    onClick: () -> Unit,
    group_name: String,
    onDeleteClick: () -> Unit,
    ) {
    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = group_name,
                    fontFamily = poppins,
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 6.dp, end = 16.dp),
                    textAlign = TextAlign.Center,
                )

                Row {
                    ProfileUserLain()
                }

            }
            Row (modifier = Modifier.align(Alignment.CenterVertically)){
                Button(
                    onClick = {
                        // routing msh belum jadi
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF22D3EE)),
                ) {
                    Text(text = "Open", fontFamily = poppins)
                }
                IconButton(onClick = onDeleteClick ,
                    modifier = Modifier.align(Alignment.Top)) {
                    Icon(Icons.Default.Delete, "delete", tint = Color.Red)

                }
            }

        }
    }
}


@Composable
fun ProfileUserLain(modifier: Modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.profilepict),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(35.dp)
                .clip(CircleShape)
        )
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
fun CustomGroupName(
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

