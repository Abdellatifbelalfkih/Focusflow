package com.artimesblue.focusflow.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeeklyReviewScreen(onBack: () -> Unit) {
    Scaffold(topBar = { TopAppBar(title = { Text("Week review") }) }) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            Text("Bekijk je voortgang en stel doelen bij. In een volgende versie komt hier een grafiek.")
        }
    }
}