package com.example.alp_vp.viewmodel.group

import androidx.lifecycle.ViewModel
import com.example.alp_vp.model.Group
import com.example.alp_vp.model.GroupUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GroupViewModel : ViewModel(){
    private val currentData = MutableStateFlow(GroupUIState())
    val data: StateFlow<GroupUIState> = currentData.asStateFlow()

    fun addGroup(name: String, description: String) {
        val groupList = currentData.value.groups.toMutableList()
        groupList.add(Group(group_name = name, description = description))
        currentData.update {
            it.copy(groups = groupList)
        }
    }

    fun deleteGroup(group: Group) {
        val groupList = currentData.value.groups.toMutableList()
        groupList.remove(group)
        currentData.update {
            it.copy(groups = groupList)
        }
    }


}