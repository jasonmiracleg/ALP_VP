package com.example.alp_vp.model

import java.sql.Time
import kotlin.time.Duration.Companion.hours

@Suppress("DEPRECATION")
data class ToDoList(
    val title: String,
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
