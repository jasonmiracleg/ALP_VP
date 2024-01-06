//package com.example.alp_vp.viewmodel.to_do_list
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableIntStateOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.alp_vp.model.TimerUIState
//import com.example.alp_vp.model.ToDoList
//import com.example.alp_vp.model.isComplete
//import com.example.alp_vp.model.isGroup
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.Job
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import java.sql.Time
//
//class TimerViewModel(toDoList: ToDoList = ToDoList("", ArrayList(), "", isGroup.group, isComplete.done, Time.valueOf("12:15:00"))) :
//    ViewModel() {
//    private val currentData = MutableStateFlow(TimerUIState())
//    val data: StateFlow<TimerUIState> = currentData.asStateFlow()
//
//    private var timerJob: Job? = null
//    private var remainingTimeInSeconds by mutableIntStateOf(0)
//    private var totalElapsedTimeInSeconds by mutableIntStateOf(0)
//
//    init {
//        setSelectedToDoList(toDoList)
//    }
//
//    private fun setSelectedToDoList(toDoList: ToDoList) {
//        currentData.value.setToDoListCustom(toDoList)
//        remainingTimeInSeconds = toDoList.totalSeconds
//        updateTimerState()
//    }
//
//    fun toggleTimer() {
//        if (timerJob?.isActive == true) {
//            timerJob?.cancel()
//            val updatedToDoList =
//                currentData.value.toDoList?.copy(totalSeconds = remainingTimeInSeconds)
//            if (updatedToDoList != null) {
//                currentData.value.setToDoListCustom(updatedToDoList)
//            }
//            updateTimerState() // Update the UI state
//        } else {
//            timerJob = viewModelScope.launch {
//                while (remainingTimeInSeconds > 0) {
//                    delay(1000)
//                    remainingTimeInSeconds--
//                    totalElapsedTimeInSeconds++
//                    updateTimerState()
//                }
//            }
//        }
//    }
//
////    fun completeToDoList(){
////        val currentUser = getCurrentUser()
////        val productiveTime = calculateProductiveTimer(totalElapsedTimeInSeconds)
////        currentUser.prodcutiveTime += productiveTime
////    }
//
//    @Suppress("DEPRECATION")
//    private fun calculateProductiveTime(totalElapsedTimeInSeconds: Int): Time {
//        val hours = totalElapsedTimeInSeconds / 3600
//        val minutes = (totalElapsedTimeInSeconds % 3600) / 60
//        val seconds = totalElapsedTimeInSeconds % 60
//
//        return Time(hours, minutes, seconds)
//    }
//
//    private fun updateTimerState() {
//        val hours = remainingTimeInSeconds / 3600
//        val minutes = (remainingTimeInSeconds % 3600) / 60
//        val seconds = remainingTimeInSeconds % 60
//        val updatedState = currentData.value.copy(
//            timerHours = hours,
//            timerMinutes = minutes,
//            timerSeconds = seconds
//        )
//        currentData.value = updatedState
//    }
//}