package com.example.attendancetracker.database

import com.example.attendancetracker.model.Schedule

class HomeRepository {

    fun getAttendance(): Int = 85

    fun getSchedule(): List<Schedule> = listOf(
        Schedule("Mathematics", "Room 201", "09:00 AM", "Attended"),
        Schedule("Physics", "Lab 102", "11:00 AM", "Upcoming")
    )
}