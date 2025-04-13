package com.example.attendancetracker.ui.screens

import android.net.Uri
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
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import coil.compose.rememberAsyncImagePainter
import com.example.attendancetracker.navigation.Screen

@Composable
fun SettingsScreen(navController: NavController, innerPadding: PaddingValues) {
    val context = LocalContext.current
    var isDarkModeEnabled by remember { mutableStateOf(false) }
    var issueText by remember { mutableStateOf(TextFieldValue("")) }
    var screenshotUri by remember { mutableStateOf<Uri?>(null) }
    var verticalScroll = rememberScrollState()

    val imagePickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            screenshotUri = uri
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(verticalScroll)
            .padding(innerPadding)
            .padding(horizontal = 16.dp)
    ) {
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
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = issueText,
            onValueChange = { issueText = it },
            placeholder = { Text("Describe the issue...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Screenshot Picker
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { imagePickerLauncher.launch("image/*") }
                .padding(vertical = 8.dp)
                .border(1.dp, Color(0xFF3578E5), RoundedCornerShape(10.dp)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .height(100.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Attach Screenshot",
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF3578E5)
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Image Preview
                screenshotUri?.let {
                    Image(
                        painter = rememberAsyncImagePainter(it),
                        contentDescription = "Selected Screenshot",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.dp, Color.Gray, RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }
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
        LegalItem("Privacy Policy", Screen.PrivacyPolicy.route, navController)
        LegalItem("Terms & Conditions", Screen.TermsAndConditions.route, navController)

        Spacer(modifier = Modifier.height(16.dp))

        // Data Management Section
        Text(text = "Data Management", fontWeight = FontWeight.Bold)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(Color(0xFFFFE5E5))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
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
                    text = "This will delete all local data and restore default settings.",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
            }
        }
    }
}


@Composable
fun LegalItem(title: String, destination: String, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate(destination) }, // Type-safe navigation
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