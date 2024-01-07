package com.example.alp_vp.viewmodel.group

import androidx.lifecycle.ViewModel
import com.example.alp_vp.model.GroupTodolist
import com.example.alp_vp.model.GroupTodolistUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GroupTodolistViewModel : ViewModel(){
    private val currentData = MutableStateFlow(GroupTodolistUIState())
    val data: StateFlow<GroupTodolistUIState> = currentData.asStateFlow()

    fun addGroupTask(task_title: String, description: String) {
        val groupTaskList = currentData.value.groupTasks.toMutableList()
        groupTaskList.add(GroupTodolist(task_title = task_title, description = description))
        currentData.update {
            it.copy(groupTasks = groupTaskList)
        }
    }

    fun deleteGroup(groupTask: GroupTodolist) {
        val groupTaskList = currentData.value.groupTasks.toMutableList()
        groupTaskList.remove(groupTask)
        currentData.update {
            it.copy(groupTasks = groupTaskList)
        }
    }


}