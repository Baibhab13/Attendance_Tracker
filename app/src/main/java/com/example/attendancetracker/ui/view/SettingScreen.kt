package com.example.attendancetracker.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import android.widget.Toast
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Composable
fun SettingsScreen(navController: NavController, innerPadding: PaddingValues) {
    val context = LocalContext.current
    var isDarkModeEnabled by remember { mutableStateOf(false) }
    var issueText by remember { mutableStateOf(TextFieldValue("")) }
    var isScreenshotAttached by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding) // Ensure content does not go behind TopBar and BottomBar
            .padding(horizontal = 16.dp) // Maintain proper content alignment
    ) {
        Text(text = "Settings", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        // Theme Section
        Text(text = "Theme", fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Dark Mode")
            Switch(
                checked = isDarkModeEnabled,
                onCheckedChange = { isDarkModeEnabled = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Report an Issue Section
        Text(text = "Report an Issue", fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = issueText,
            onValueChange = { issueText = it },
            placeholder = { Text("Describe the issue...") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isScreenshotAttached = !isScreenshotAttached },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Attach Screenshot", modifier = Modifier.padding(start = 8.dp))
        }
        Button(
            onClick = {
                Toast.makeText(context, "Report Submitted", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF3578E5))
        ) {
            Text(text = "Submit Report", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Legal Section
        Text(text = "Legal", fontWeight = FontWeight.Bold)
        LegalItem("Privacy Policy", navController)
        LegalItem("Terms & Conditions", navController)

        Spacer(modifier = Modifier.height(16.dp))

        // Data Management Section
        Text(text = "Data Management", fontWeight = FontWeight.Bold)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(Color(0xFFFFE5E5))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Reset App Data",
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    modifier = Modifier.clickable {
                        Toast.makeText(context, "App Data Reset!", Toast.LENGTH_SHORT).show()
                    }
                )
                Text(
                    text = "This will delete all your local data and restore default settings",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun LegalItem(title: String, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { /* Handle navigation here */ },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Text(text = ">", color = Color.Gray)
        }
    }
}