package com.example.alp_vp.viewmodel.to_do_list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alp_vp.data.DataStoreManager
import com.example.alp_vp.model.APIListResponse
import com.example.alp_vp.model.ToDoList
import com.example.alp_vp.model.ToDoListV2
import com.example.alp_vp.repository.MyDBContainer
import com.example.alp_vp.ui.ListScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

sealed interface HomeUIState {
    data class Success(
        val user: Int,
        val listToDo: Response<APIListResponse<List<ToDoList>>>
    ) : HomeUIState

    object Error : HomeUIState
    object Loading : HomeUIState
}

class HomeViewModel : ViewModel() {
//    private val _uiState = MutableStateFlow(HomeUiState())
//    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()


    var homeuiState: HomeUIState by mutableStateOf(HomeUIState.Loading)
        private set

    lateinit var data: Response<APIListResponse<List<ToDoList>>>

    init {
        loadKonten()
    }

    private fun loadKonten() {
        viewModelScope.launch {
            try {
                data = MyDBContainer().tiemerDBRepositories.getAllToDoList(
                    MyDBContainer.ACCESS_TOKEN, MyDBContainer.USER_ID
                )
                Log.d("data", data.toString())
                homeuiState = HomeUIState.Success(MyDBContainer.USER_ID, data)

            } catch (e: Exception) {
//                Log.d("FAILED", e.message.toString())
                homeuiState = HomeUIState.Error
            }
        }
    }

    fun logout(
        dataStore: DataStoreManager,
        navController: NavController
    ) {
        viewModelScope.launch {
            MyDBContainer().tiemerDBRepositories.logout()
            dataStore.saveToken("", -1)
            MyDBContainer.USER_ID = -1
            MyDBContainer.ACCESS_TOKEN = ""
            navController.navigate(ListScreen.SplashScreen.name)
        }
    }

    private val todoListLiveData = MutableLiveData<List<ToDoListV2>>()

    fun updatetoDoList(data: ToDoList, result: Boolean) {
        viewModelScope.launch {
            Log.d("tdl", data.toString())
            MyDBContainer().tiemerDBRepositories.updateCompleteToDoListToDay(
                MyDBContainer.ACCESS_TOKEN,
                data,
                result
            )
        }
    }
}