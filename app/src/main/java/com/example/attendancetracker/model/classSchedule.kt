package com.example.attendancetracker.model

import java.time.LocalDate

data class ClassSchedule(
    val date: LocalDate,
    val subject: String,
    val professor: String,
    val location: String,
    val time: String,
    val note: String? = null
)
