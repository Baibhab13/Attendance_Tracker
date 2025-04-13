package com.example.attendancetracker.viewModel

import androidx.lifecycle.ViewModel
import com.example.attendancetracker.database.HomeRepository
import com.example.attendancetracker.model.Schedule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val repository = HomeRepository()

    private val _attendance = MutableStateFlow(repository.getAttendance())
    val attendance: StateFlow<Int> = _attendance

    private val _schedule = MutableStateFlow(repository.getSchedule())
    val schedule: StateFlow<List<Schedule>> = _schedule
}