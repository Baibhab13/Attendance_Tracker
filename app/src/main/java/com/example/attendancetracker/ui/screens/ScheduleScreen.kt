package com.example.attendancetracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.attendancetracker.model.ClassSchedule
import com.example.attendancetracker.viewModel.ScheduleViewModel
import java.time.format.DateTimeFormatter

@Composable
fun ScheduleScreen(
    innerPadding: PaddingValues,
    viewModel: ScheduleViewModel = viewModel()
) {
    val selectedDate = viewModel.selectedDate.collectAsState().value
    val schedules = viewModel.getSchedulesForDate(selectedDate)
    val weekDates = viewModel.getWeekDates()

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Title
        Text("Class Schedule", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(12.dp))

        // Calendar Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            weekDates.forEach { date ->
                val isSelected = date == selectedDate
                val day = date.format(DateTimeFormatter.ofPattern("EEE"))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (isSelected) Color(0xFF3578E5) else Color(0xFFF5F5F5))
                        .clickable { viewModel.onDateSelected(date) }
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                ) {
                    Text(day, color = if (isSelected) Color.White else Color.Black)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Class List
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(schedules) { schedule ->
                ClassCard(schedule)
            }
        }
    }
}

@Composable
fun ClassCard(schedule: ClassSchedule) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(schedule.subject, fontWeight = FontWeight.Bold)
                Text(schedule.time, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(schedule.professor, color = Color.Gray, fontSize = 13.sp)
            Text(schedule.location, color = Color.Gray, fontSize = 13.sp)

            schedule.note?.let {
                Spacer(modifier = Modifier.height(6.dp))
                Box(
                    modifier = Modifier
                        .background(Color(0xFFDFFFE0), RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(it, color = Color(0xFF2B9720), fontSize = 12.sp)
                }
            }
        }
    }
}
