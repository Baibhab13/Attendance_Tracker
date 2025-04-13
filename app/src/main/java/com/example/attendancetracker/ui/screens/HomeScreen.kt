package com.example.attendancetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.attendancetracker.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        DashboardContent(
            viewModel = viewModel() 
        )
    }
}

@Composable
fun DashboardContent(viewModel: HomeViewModel) {
    val attendance = viewModel.attendance.collectAsState().value
    val schedule = viewModel.schedule.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        // ATTENDANCE CARD
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Attendance Overview", fontWeight = FontWeight.Bold)
                    Text("Safe Zone", color = Color.Green, fontSize = 12.sp)
                }
                Spacer(Modifier.height(12.dp))
                Text("$attendance%", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                Text("Attendance", color = Color.Gray)
            }
        }

        Spacer(Modifier.height(20.dp))

        // 🟢 SCHEDULE SECTION
        Text("Today's Schedule", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))

        schedule.value.forEach { scheduleItem ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Column(Modifier.padding(12.dp)) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(scheduleItem.subject, fontWeight = FontWeight.SemiBold)
                        Text(scheduleItem.time, fontWeight = FontWeight.Light)
                    }
                    Spacer(Modifier.height(4.dp))
                    Text(scheduleItem.room, color = Color.Gray, fontSize = 12.sp)
                    Text(
                        scheduleItem.status,
                        color = when (scheduleItem.status) {
                            "Attended" -> Color(0xFF4CAF50)
                            "Upcoming" -> Color(0xFF2196F3)
                            else -> Color.Gray
                        },
                        fontSize = 12.sp
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))
    }
}
