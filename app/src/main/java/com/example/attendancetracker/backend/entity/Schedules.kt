package com.example.attendancetracker.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="TimeTable")
data class SchedulesEntity (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val subject: String,
    val room: String,
    val time: String,
    val status: String
)