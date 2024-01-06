package com.example.alp_vp.viewmodel.to_do_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.alp_vp.model.FormCreateUiState
import com.example.alp_vp.model.ToDoList
import com.example.alp_vp.ui.view.to_do_list.category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FormCreateViewModel: ViewModel(

){
    private val _uiState = MutableStateFlow(FormCreateUiState(title = "", alarmHours = 0, alarmMinutes = 0, timerHours = 0, timerMinutes = 0, timerSeconds = 0, description = ""))

    val uiState: StateFlow<FormCreateUiState> = _uiState.asStateFlow()

    var inputTitle by mutableStateOf("")
        private set

    var inputAlarmHours by mutableStateOf("")
        private set

    var inputAlarmMinutes by mutableStateOf("")
        private set

    var inputTimerHours by mutableStateOf("")
        private set

    var inputTimerMinutes by mutableStateOf("")
        private set

    var inputTimerSecond by mutableStateOf("")
        private set

    var inputDescription by mutableStateOf("")
        private set

    fun menerimaInputanTitle (title: String){
        inputTitle = title
    }

    fun menerimaInputanAlarmHours (alarmHours: String){
        inputAlarmHours = alarmHours
    }

    fun menerimaInputanAlarmMinutes (alarmMinutes: String){
        inputAlarmMinutes = alarmMinutes
    }

    fun menerimaInputanTimerHours (timerHourse: String){
        inputTimerHours = timerHourse
    }

    fun menerimaInputanTimerMinutes (timerMinutes: String){
        inputTimerMinutes = timerMinutes
    }

    fun menerimaInputanTimerSecond (timerSecond: String){
        inputTimerSecond = timerSecond
    }

    fun menerimaInputanDescription (description: String){
        inputDescription = description
    }

//     fun buttonSubmitDiKlik(){
//        tambahToDoList()
//    }
//
//    private fun tambahToDoList() {
//        var toDoListSementara = FormCreateUiState(title = inputTitle, category = Category(title = '', color = ''), alarmHours = inputAlarmHours.toInt(), alarmMinutes = inputAlarmMinutes.toInt(), timerHours = inputTimerHours.toInt(), timerMinutes = inputTimerMinutes.toInt(), timerSeconds = inputTimerSecond.toInt(), description = inputDescription)
//    }
}