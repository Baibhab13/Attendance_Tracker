package com.example.attendancetracker.model

data class Schedule(
    val subject: String,
    val room: String,
    val time: String,
    val status: String // Attended, Upcoming
)