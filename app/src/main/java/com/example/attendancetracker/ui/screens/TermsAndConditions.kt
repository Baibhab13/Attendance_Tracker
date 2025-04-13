package com.example.attendancetracker.ui.screens

import androidx.compose.runtime.Composable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsAndConditionsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Terms & Conditions") },
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
                    text = "Terms & Conditions",
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
                    "By using this app, you agree to be bound by these Terms and Conditions. Please read them carefully before using the app."
                )

                SectionTitle("2. User Responsibilities")
                SectionText(
                    "Users must use the app in compliance with all applicable laws and regulations. Any misuse of the app may result in termination of access."
                )

                SectionTitle("3. License and Restrictions")
                SectionText(
                    "You are granted a limited, non-exclusive, non-transferable license to use the app. You may not modify, distribute, or sell any part of the app."
                )

                SectionTitle("4. Limitation of Liability")
                SectionText(
                    "We are not liable for any indirect, incidental, or consequential damages that result from the use of this app."
                )

                SectionTitle("5. Privacy Policy")
                SectionText(
                    "By using the app, you also agree to our Privacy Policy. Please review it to understand how we handle your data."
                )

                SectionTitle("6. Changes to Terms")
                SectionText(
                    "We may update these Terms & Conditions from time to time. Users will be notified of significant changes."
                )

                SectionTitle("7. Contact Us")
                SectionText(
                    "If you have any questions about these Terms, please contact us at support@yourapp.com."
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Accept Button
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color(0xFF3578E5))
                ) {
                    Text(text = "Accept", color = Color.White)
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}


