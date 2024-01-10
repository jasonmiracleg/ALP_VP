package com.example.alp_vp.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import java.math.BigInteger
import java.sql.Time
import java.util.Date

@Suppress("DEPRECATION")
data class ToDoList(
    val id: Int = 0,
    val title: String,
    val listCategory: ArrayList<Category> = arrayListOf(),
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

data class ToDoListV2(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
//    @SerializedName("is_group") val is_group: String,
//    @SerializedName("is_complete") val is_complete: String,
//    @SerializedName("description") val description: String?,
//    @SerializedName("timer") val timer: String?,
//    @SerializedName("total_seconds") val total_seconds: Int?,
//    @SerializedName("timer_started") val timer_started: String?,
//    @SerializedName("user_id") val user_id: Int,
//    @SerializedName("group_id") val group_id: Int?,
//    @SerializedName("reminder_id") val reminder_id: Int?,
//    @SerializedName("date") val date: Date,
//    @SerializedName("day") val day: Date,
//    @SerializedName("created_at") val created_at: String,
//    @SerializedName("updated_at") val updated_at: String
)

//data class ToDoListV3(
//    val id: Int = 0,
//    val title: String = "",
//)

data class ToDoListResponse(
    val id: Int = 0,
    val title: String = "",
    val is_group: String = "0", //harusnya enum? but coba aja dulu
    val is_complete: String = "0",
    val description: String? = "",
    val timer: String? = "", // time haruse?
    val total_seconds: Int? = 0,
    val timer_started: String? = "0",
    val user_id: Int = 0, //haruse bigIn
    val group_id : Int?, //ini null
    val date: String = "",
    val day: String = ""
)

data class ToDoListCreate(
    @SerializedName("title") val title: String,
    @SerializedName("is_group") val is_group: String,
    @SerializedName("description") val description: Any,
    @SerializedName("date") val date: String,
    @SerializedName("day") val day: String
)

data class ToDoListComplete(
    @SerializedName("id") val id: Int,
    @SerializedName("is_complete") val is_complete: String
)