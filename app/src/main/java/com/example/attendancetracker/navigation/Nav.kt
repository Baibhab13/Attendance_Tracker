package com.example.attendancetracker.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.attendancetracker.ui.view.CalendarScreen
import com.example.attendancetracker.ui.view.HomeScreen
import com.example.attendancetracker.ui.view.MainScaffold
import com.example.attendancetracker.ui.view.SettingsScreen
import kotlinx.serialization.Serializable

@Composable
fun Nav() {
    val navCtrl = rememberNavController()

    NavHost(navController = navCtrl, startDestination = MainScaffold) {
        composable<MainScaffold> {
            MainScaffold(
                viewModel = viewModel()
            )
        }

        composable<Home> {
            HomeScreen(innerPadding = PaddingValues())
        }
        composable<Calendar> {
            CalendarScreen(innerPadding = PaddingValues())
        }
        composable<Setting> {
            SettingsScreen(innerPadding = PaddingValues())
        }
    }

}

@Serializable
object MainScaffold

@Serializable
object Home

@Serializable
object Calendar

@Serializable
object Setting

