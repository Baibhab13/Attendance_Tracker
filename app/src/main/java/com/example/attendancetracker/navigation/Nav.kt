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
import com.example.attendancetracker.ui.view.PrivacyPolicyScreen
import com.example.attendancetracker.ui.view.SettingsScreen
import com.example.attendancetracker.ui.view.TermsAndConditionsScreen
import kotlinx.serialization.Serializable

@Composable
fun Nav() {
    val navCtrl = rememberNavController()

    NavHost(navController = navCtrl, startDestination = Screen.MainScaffold.route) {
        composable(Screen.MainScaffold.route) {
            MainScaffold(navCtrl, viewModel = viewModel())
        }
        composable(Screen.Home.route) {
            HomeScreen(navCtrl, innerPadding = PaddingValues())
        }
        composable(Screen.Calendar.route) {
            CalendarScreen(innerPadding = PaddingValues())
        }
        composable(Screen.Setting.route) {
            SettingsScreen(navCtrl, innerPadding = PaddingValues())
        }
        composable(Screen.PrivacyPolicy.route) {
            PrivacyPolicyScreen(navCtrl)
        }
        composable(Screen.TermsAndConditions.route) {
            TermsAndConditionsScreen(navCtrl)
        }
    }


}

@Serializable
sealed class Screen(val route: String) {
    @Serializable object MainScaffold : Screen("mainScaffold")
    @Serializable object Home : Screen("home")
    @Serializable object Calendar : Screen("calendar")
    @Serializable object Setting : Screen("settings")
    @Serializable object PrivacyPolicy : Screen("privacy_policy")
    @Serializable object TermsAndConditions : Screen("terms_conditions")
}
