package com.example.attendancetracker.viewModel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.attendancetracker.model.navItem

class ScaffoldViewModel: ViewModel() {

    val selectedIndex = mutableIntStateOf(0)

    val expanded = mutableStateOf(false)

    val navItem = listOf(
        navItem("Home", Icons.Outlined.Home, Icons.Default.Home),
        navItem("Schedule", Icons.Outlined.DateRange, Icons.Default.DateRange),
        navItem("Settings", Icons.Outlined.Settings, Icons.Default.Settings)
    )
}