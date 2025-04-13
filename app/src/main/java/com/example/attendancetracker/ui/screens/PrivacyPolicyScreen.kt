package com.example.attendancetracker.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Privacy Policy") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Privacy Policy",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Last Updated: March 2024",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                SectionTitle("1. Introduction")
                SectionText(
                    "Welcome to our app! Your privacy is important to us. This Privacy Policy explains how we collect, use, and protect your information."
                )

                SectionTitle("2. Information We Collect")
                SectionText(
                    "We may collect personal information such as your name, email address, and usage data to improve our services. We do not share your data with third parties without your consent."
                )

                SectionTitle("3. How We Use Your Information")
                SectionText(
                    "We use your information to provide and improve our services, send updates, and enhance user experience."
                )

                SectionTitle("4. Security Measures")
                SectionText(
                    "We implement appropriate security measures to protect your data from unauthorized access, alteration, or disclosure."
                )

                SectionTitle("5. Contact Us")
                SectionText(
                    "If you have any questions about our Privacy Policy, please contact us at support@yourapp.com."
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Acknowledgment
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color(0xFF3578E5))
                ) {
                    Text(text = "I Understand", color = Color.White)
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun SectionText(content: String) {
    Text(
        text = content,
        fontSize = 14.sp,
        color = Color.DarkGray,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}
