package com.example.attendancetracker.viewModel

import androidx.lifecycle.ViewModel
import com.example.attendancetracker.model.ClassSchedule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate

class ScheduleViewModel : ViewModel() {

    private val _selectedDate = MutableStateFlow(LocalDate.now())
    val selectedDate: StateFlow<LocalDate> = _selectedDate

    private val _scheduleList = MutableStateFlow(sampleSchedules())

    fun onDateSelected(date: LocalDate) {
        _selectedDate.value = date
    }

    fun getWeekDates(): List<LocalDate> {
        val today = LocalDate.now()
        val startOfWeek = today.with(java.time.DayOfWeek.MONDAY)
        return (0..6).map { startOfWeek.plusDays(it.toLong()) } // ✅ now 7 days (Mon–Sun)
    }

    fun getSchedulesForDate(date: LocalDate): List<ClassSchedule> {
        return _scheduleList.value.filter { it.date == date }
    }

    private fun sampleSchedules(): List<ClassSchedule> {
        val today = LocalDate.now()
        val startOfWeek = today.with(java.time.DayOfWeek.MONDAY)

        return listOf(
            // Monday
            ClassSchedule(startOfWeek, "Mathematics", "Prof. Anderson", "Room 201", "09:00 - 10:30 AM", "Next in 10 min"),
            ClassSchedule(startOfWeek, "Biology", "Prof. Lee", "Room 105", "11:00 - 12:00 PM"),

            // Tuesday
            ClassSchedule(startOfWeek.plusDays(1), "Physics", "Prof. Smith", "Lab 102", "10:00 - 11:30 AM"),
            ClassSchedule(startOfWeek.plusDays(1), "English", "Prof. Brown", "Room 202", "01:00 - 02:00 PM"),

            // Wednesday
            ClassSchedule(startOfWeek.plusDays(2), "Chemistry", "Prof. Williams", "Lab 305", "09:00 - 10:30 AM"),
            ClassSchedule(startOfWeek.plusDays(2), "History", "Prof. Clark", "Room 110", "11:00 - 12:00 PM"),

            // Thursday
            ClassSchedule(startOfWeek.plusDays(3), "Geography", "Prof. Davis", "Room 204", "08:30 - 10:00 AM"),
            ClassSchedule(startOfWeek.plusDays(3), "Computer Science", "Prof. Taylor", "Lab 301", "10:30 - 12:00 PM"),

            // Friday
            ClassSchedule(startOfWeek.plusDays(4), "Economics", "Prof. Thomas", "Room 207", "09:00 - 10:30 AM"),

            // Saturday
            ClassSchedule(startOfWeek.plusDays(5), "Physical Education", "Coach Evans", "Gym", "10:00 - 11:30 AM"),

            // Sunday (could be holiday or revision sessions)
            ClassSchedule(startOfWeek.plusDays(6), "Optional Revision", "Prof. Martinez", "Room 101", "09:00 - 10:00 AM")
        )
    }
}