package com.example.alp_vp.viewmodel.group

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alp_vp.R
import com.example.alp_vp.model.APIListResponse
import com.example.alp_vp.model.Group
import com.example.alp_vp.model.User
import com.example.alp_vp.repository.MyDBContainer
import com.example.alp_vp.ui.ListScreen
import kotlinx.coroutines.launch
import retrofit2.Response



sealed interface GroupUIState{
    data class Success(val user: Int, val listGroup: Response<APIListResponse<List<Group>>>) :
        GroupUIState

    object Error : GroupUIState
    object Loading : GroupUIState
}

class GroupViewModel : ViewModel(){

    var groupUIState: GroupUIState by mutableStateOf(GroupUIState.Loading)
        private set

    lateinit var allGroup: Response<APIListResponse<List<Group>>>

    var searchResult: List<User> by mutableStateOf(emptyList())
        private set

    init {
        initialGroupUIState()
    }

    fun createGroup(group_name: String, description: String, navController: NavController){
        viewModelScope.launch {
            val userId = MyDBContainer.USER_ID
            val token = MyDBContainer.ACCESS_TOKEN
            MyDBContainer().tiemerDBRepositories.createGroup(
                group_name, description, userId, token
            )
            navController.navigate(ListScreen.TeamList.name)
        }
    }

    fun getGroups() {
        viewModelScope.launch {

            val userId = MyDBContainer.USER_ID
            val token = MyDBContainer.ACCESS_TOKEN

            allGroup = MyDBContainer().tiemerDBRepositories.getGroups(token, userId)
        }
    }



    fun deleteGroup(id: Int, navController: NavController) {
        viewModelScope.launch {
            val token = MyDBContainer.ACCESS_TOKEN
            MyDBContainer().tiemerDBRepositories.deleteGroup(
                token, id
            )
            navController.navigate(ListScreen.TeamList.name)
        }
    }


    //search and add other users function

    fun searchUserByUsername(username: String) {
        viewModelScope.launch {

//            searchResult = MyDBContainer().tiemerDBRepositories.searchUserByUsername(username)

            //menyesuaikan dengan API user
        }
    }
//    fun getUserProfileImage(userId: Int): Painter {
//        val user = MyDBContainer().tiemerDBRepositories.getUserById(userId)
//
//        // jika image gda maka pake gambar no profile
//        return if (user.image != null) {
//            painterResource(id = user.profileImage)
//        } else {
//            painterResource(id = R.drawable.default_profile_image)
//        }
//    }

    private fun initialGroupUIState() {
        viewModelScope.launch {
            allGroup = MyDBContainer().tiemerDBRepositories.getGroups(
                MyDBContainer.ACCESS_TOKEN,
                MyDBContainer.USER_ID
            )
            Log.d("Group", allGroup.toString())
            groupUIState = GroupUIState.Success(MyDBContainer.USER_ID, allGroup)
        }
    }

}