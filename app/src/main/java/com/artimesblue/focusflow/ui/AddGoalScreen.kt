@file:OptIn(ExperimentalMaterial3Api::class)

package com.artimesblue.focusflow.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artimesblue.focusflow.domain.DashboardViewModel

private val goalCategories = listOf("Focus", "Gezondheid", "Leren", "Creatief", "Sociaal")

@Composable
fun AddGoalScreen(onDone: () -> Unit) {
    val vm: DashboardViewModel = viewModel()
    var name by remember { mutableStateOf("") }
    var category by remember { mutableStateOf(goalCategories.first()) }
    var difficulty by remember { mutableStateOf(2f) }
    var targetMinutes by remember { mutableStateOf(25f) }
    var expanded by remember { mutableStateOf(false) }

    Scaffold(topBar = { TopAppBar(title = { Text("Nieuwe goal") }) }) { padding ->
        Column(Modifier.padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Naam") },
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = it }) {
                OutlinedTextField(
                    value = category,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Categorie") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier.menuAnchor().fillMaxWidth()
                )
                ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    goalCategories.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                category = item
                                expanded = false
                            }
                        )
                    }
                }
            }
            Text("Moeilijkheid: ${difficulty.toInt()}")
            Slider(
                value = difficulty,
                onValueChange = { difficulty = it },
                valueRange = 1f..5f,
                steps = 3
            )
            Text("Doel (minuten): ${targetMinutes.toInt()}")
            Slider(
                value = targetMinutes,
                onValueChange = { targetMinutes = it },
                valueRange = 5f..120f,
                steps = 23
            )
            Button(
                onClick = {
                    if (name.isNotBlank()) {
                        vm.addGoal(name, category, difficulty.toInt(), targetMinutes.toInt())
                        onDone()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Opslaan")
            }
        }
    }
}
