package com.example.alp_vp.model

import com.google.gson.annotations.SerializedName
import java.sql.Time

data class Reminder(
    @SerializedName("time_hours") val time_hours: Int,
    @SerializedName("time_minutes") val time_minutes: Int
)