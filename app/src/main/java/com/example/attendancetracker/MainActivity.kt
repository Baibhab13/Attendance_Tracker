package com.example.attendancetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.attendancetracker.navigation.Nav
import com.example.attendancetracker.ui.theme.AttendanceTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AttendanceTrackerTheme{
                Nav()
            }
        }
    }
}