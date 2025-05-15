package com.example.attendancetracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.attendancetracker.ui.components.CircularProgressBar
import com.example.attendancetracker.viewModel.HomeViewModel

@Composable
fun HomeScreen(
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

    var dialogDisplayed by remember { mutableStateOf(false) }
    var targetPercentage = viewModel.targetPercentage

    if (dialogDisplayed == true) {
        Dialog(
            onDismissRequest = {
                dialogDisplayed = false
            }
        ) {
            Column(
                modifier = Modifier
                    .size(300.dp, 200.dp)
                    .background(color = Color.Black.copy(alpha = 0.5f))
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = targetPercentage.value,
                    onValueChange = {
                        targetPercentage.value = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = {
                        dialogDisplayed = false
                    },
                ) {
                    Text(text = "Update")
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth(),
        ) {
            CircularProgressBar(
                percentage = targetPercentage.value.toFloatOrNull()?.div(100f) ?: 0.75f,
                number = 100,
            )
        }

        Button(
            onClick = { dialogDisplayed = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text = "Set Target")
        }
    }
}