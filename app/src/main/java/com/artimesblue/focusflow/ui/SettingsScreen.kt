package com.artimesblue.focusflow.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(onBack: () -> Unit) {
    var smartNudges by remember { mutableStateOf(true) }
    var vibration by remember { mutableStateOf(true) }
    var dailyReviewHour by remember { mutableStateOf(21) }

    Scaffold(topBar = { TopAppBar(title = { Text("Instellingen") }) }) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Slimme nudges")
                Switch(checked = smartNudges, onCheckedChange = { smartNudges = it })
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Trillen bij herinneringen")
                Switch(checked = vibration, onCheckedChange = { vibration = it })
            }
            Spacer(Modifier.height(8.dp))
            Text("Dagelijkse review om: ${dailyReviewHour}:00")
            Slider(
                value = dailyReviewHour.toFloat(),
                onValueChange = { dailyReviewHour = it.toInt() },
                valueRange = 18f..23f,
                steps = 4
            )
        }
    }
}
