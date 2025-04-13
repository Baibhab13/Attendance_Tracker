package com.example.attendancetracker.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.attendancetracker.viewModel.ScaffoldViewModel

@Composable
fun MainScaffold(navController: NavController, viewModel: ScaffoldViewModel) {
    Scaffold(
        topBar = {
           TopBar(navController, viewModel)
        },
        bottomBar = {
            BottomNavigationBar(viewModel)
        },
        floatingActionButton = {
            when(viewModel.selectedIndex.intValue) {
                0 -> FloatingActionButton(viewModel)
            }
        }
    ) {innerPadding ->
        ContentScreen(navController, viewModel, innerPadding)
    }
}

@Composable
fun ContentScreen(navController: NavController, viewModel: ScaffoldViewModel, innerPadding: PaddingValues) {
    when(viewModel.selectedIndex.intValue) {
        0 -> HomeScreen(navController, innerPadding)
        1 -> ScheduleScreen(innerPadding)
        2 -> SettingsScreen(navController, innerPadding)
    }
}

@Composable
fun FloatingActionButton(viewModel: ScaffoldViewModel) {
    FloatingActionButton(
        onClick = { /*TODO*/ }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Set Target"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController, viewModel: ScaffoldViewModel) {
    TopAppBar(
        title = {
            when(viewModel.selectedIndex.intValue) {
                0 -> Text("Attendance Tracker")
                1 -> Text("Schedule")
                2 -> Text("Settings")
            }
        },
        actions = {
            IconButton(
                onClick = { viewModel.expanded.value = true }
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More Options"
                )
            }
            DropdownMenu(
                modifier = Modifier.width(150.dp),
                expanded = viewModel.expanded.value,
                onDismissRequest = { viewModel.expanded.value = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Setting") },
                    onClick = {
                        viewModel.selectedIndex.intValue = 2
                        viewModel.expanded.value = false
                    }
                )
            }
        }
    )
}

@Composable
fun BottomNavigationBar(viewModel: ScaffoldViewModel) {
    NavigationBar {
        viewModel.navItem.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == viewModel.selectedIndex.intValue,
                onClick = { viewModel.selectedIndex.intValue = index },
                icon = {
                    if (index == viewModel.selectedIndex.intValue) {
                        Icon(
                            imageVector = item.unselectedicon,
                            contentDescription = item.label
                        )
                    } else {
                        Icon(
                            imageVector = item.selectedicon,
                            contentDescription = item.label
                        )
                    }
                },
                label = {
                    Text(text = viewModel.navItem[index].label)
                }
            )
        }
    }
}
