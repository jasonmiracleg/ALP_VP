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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.alp_vp.R
import com.example.alp_vp.model.APIListResponse
import com.example.alp_vp.model.Group
import com.example.alp_vp.ui.ListScreen
import com.example.alp_vp.viewmodel.group.GroupUIState
import com.example.alp_vp.viewmodel.group.GroupViewModel
import retrofit2.Response
import androidx.compose.material3.Icon as Icon

val poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
)
@Composable
fun TeamListView(groupViewModel: GroupViewModel, navController: NavController){
//    val groupUIState by groupViewModel.data.collectAsState()

    val groupVM: GroupUIState = groupViewModel.groupUIState
    var allGroupBody: Response<APIListResponse<List<Group>>>? = null
    var userId: Int? = null

    when(groupVM){
        is GroupUIState.Success -> {
            userId = groupVM.user
            allGroupBody = groupVM.listGroup
        }
        is GroupUIState.Error -> {

        }
        GroupUIState.Loading -> {

        }
    }

    val allGroup: APIListResponse<List<Group>>? = allGroupBody?.body()


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
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            IconButton(onClick = { /*route(team_notif)*/ } ,
                modifier = Modifier.align(Alignment.Top)) {
                Icon(Icons.Outlined.Notifications, "notif")

            }
        }
        createTeam(navController, groupViewModel)
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
//            item{
//                ListGroupCard(
//
//                    "",
//                    navController = navController,
//
////                    onClick = {
////                        // Define your onClick logic here
////                    },
//                    onDeleteClick = {
//                        groupViewModel.deleteGroup(navController)
//                    }
//                ){
//
//                }
//            }
            if (allGroup != null){
                items(allGroup.data.size){
                    ListGroupCard(
                        group_name = allGroup.data[it].group_name,
                        navController,
                        groupViewModel,
                        allGroup.data[it].id
                    )
//                    {
//                    //routing
//                    }
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun createTeam(
    navController: NavController,
    groupViewModel: GroupViewModel
){

    var searchusername by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var group_name by rememberSaveable { mutableStateOf("") }

//    val searchResult by groupViewModel.searchResult.collectAsState()

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
            onValueChanged = {
                searchusername = it
//                groupViewModel.searchByUsername(it)
            },
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
                    .clickable {
                        groupViewModel.createGroup(
                            group_name,
                            description,
                            navController
                        )
                    }
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
    group_name: String,
    //colorBackground: Color = Color(0xFFEBEBEB),
    navController: NavController,
    //onClick: () -> Unit,
    groupViewModel: GroupViewModel,
    index: Int,
    //onDeleteClick: () -> Unit,
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

                // Menampilkan gambar profil untuk setiap pengguna
                Row {
                    //groupViewModel.allGroup?.data?.get(index)?.members?.forEach { user ->
                        Image(
                            painter = painterResource(id = R.drawable.profilepict), // Ganti dengan user.profileImageUrl
                            contentDescription = "Profile Picture",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .size(35.dp)
                                .clip(CircleShape)
                        )
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
                IconButton(onClick = {  groupViewModel.deleteGroup(index, navController) } ,
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
    TeamListView(groupViewModel = GroupViewModel(), navController = rememberNavController())
}

