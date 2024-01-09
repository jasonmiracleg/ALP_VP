package com.example.alp_vp.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import java.sql.Time

@Suppress("DEPRECATION")
data class ToDoList(
    val title: String,
    val listCategory:  ArrayList<Category> = arrayListOf(),
    val description: String?,
    val isGroup: isGroup,
    val isComplete: isComplete,
    val timer: Time = Time.valueOf("12:30:00"),
    var totalSeconds: Int = 0
) {
    init {
        calculateTotalSeconds()
    }

    private fun calculateTotalSeconds() {
        totalSeconds = timer.hours * 3600 + timer.minutes * 60 + timer.seconds
    }
}

@RequiresApi(Build.VERSION_CODES.O)
data class ToDoListV2(
    @SerializedName("title") val title: String = "",
    @SerializedName("user_id") val user_id: Any = "",
    @SerializedName("is_group") val is_group: Any = "",
    @SerializedName("is_complete") val is_complete: Any = "",
    @SerializedName("description") val description: Any = "",
    @SerializedName("timer") val timer: Any = "",
    @SerializedName("total_seconds") val total_seconds: Int = 0,
    @SerializedName("timer_started") val timer_started: Any = "",
    @SerializedName("reminder_id") val reminder_id: Any = "",
    @SerializedName("date") val date: Any = "",
    @SerializedName("group_id") val group_id: Any = "",
    @SerializedName("day") val day: Any = ""
)

data class ToDoListCreate(
    @SerializedName("title") val title: String,
    @SerializedName("is_group") val is_group: String,
    @SerializedName("description") val description: Any,
    @SerializedName("date") val date: String,
    @SerializedName("day") val day: String
)
