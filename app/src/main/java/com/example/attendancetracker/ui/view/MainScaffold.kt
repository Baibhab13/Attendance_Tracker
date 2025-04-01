package com.example.attendancetracker.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.attendancetracker.model.navItem
import com.example.attendancetracker.viewModel.scaffoldviewModel

@Composable
fun MainScaffold(viewModel: scaffoldviewModel) {

    Scaffold(
        topBar = {
           TopBar(viewModel)
        },
        bottomBar = {
            BottomNavigationBar(viewModel)
        }
    ) {innerPadding ->
        ContentScreen(viewModel, innerPadding)
    }
}

@Composable
fun ContentScreen(viewModel: scaffoldviewModel, innerPadding: PaddingValues) {
    when(viewModel.selectedIndex.intValue) {
        0 -> HomeScreen(innerPadding)
        1 -> CalendarScreen(innerPadding)
        2 -> SettingsScreen(innerPadding)
    }
}

@Composable
fun TopBar(viewModel: scaffoldviewModel) {

}

@Composable
fun BottomNavigationBar(viewModel: scaffoldviewModel) {
    NavigationBar {
        viewModel.navItem.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == viewModel.selectedIndex.intValue,
                onClick = { viewModel.selectedIndex.intValue = index },
                icon = {
                    if (index == viewModel.selectedIndex.intValue) {
                        item.selectedicon
                    } else {
                        item.unselectedicon
                    }
                },
                label = {
                    Text(text = viewModel.navItem[index].label)
                }
            )
        }
    }
}
