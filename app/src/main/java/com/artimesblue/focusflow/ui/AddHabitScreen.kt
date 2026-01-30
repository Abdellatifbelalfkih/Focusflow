package com.artimesblue.focusflow.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artimesblue.focusflow.domain.DashboardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddHabitScreen(onDone: () -> Unit) {
    val vm: DashboardViewModel = viewModel()
    var name by remember { mutableStateOf("") }
    var goal by remember { mutableStateOf("") }
    var unit by remember { mutableStateOf("min") }

    Scaffold(topBar = { TopAppBar(title = { Text("Nieuwe gewoonte") }) }) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(
                value = name, onValueChange = { name = it },
                label = { Text("Naam") }, modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = goal, onValueChange = { goal = it },
                label = { Text("Dagdoel") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = unit, onValueChange = { unit = it },
                label = { Text("Eenheid (bijv. min, reps)") }, modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            Button(onClick = {
                val g = goal.toIntOrNull() ?: 0
                if (name.isNotBlank() && g > 0) {
                    vm.addHabit(name, g, unit)
                    onDone()
                }
            }) { Text("Opslaan") }
        }
    }
}
