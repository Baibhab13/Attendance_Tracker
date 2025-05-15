package com.example.attendancetracker.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    var targetPercentage = mutableStateOf("")
}