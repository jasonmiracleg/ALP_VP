package com.example.alp_vp.model


data class TimerUIState(
    var timerHours: Int = 0,
    var timerMinutes: Int = 0,
    var timerSeconds: Int = 0,
    var toDoList: ToDoList? = null
) {

    init {
        this.toDoList?.let { setToDoListCustom(it) }
    }

    fun setToDoListCustom(toDoList: ToDoList) {
        this.toDoList = toDoList
        updateTimerForSpecificToDoList()
    }

    private fun updateTimerForSpecificToDoList() {
        toDoList?.let {
            val totalSeconds = it.totalSeconds
            timerHours = totalSeconds / 3600
            timerMinutes = (totalSeconds % 3600) / 60
            timerSeconds = totalSeconds % 60
        }
    }
}

