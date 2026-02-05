@file:OptIn(ExperimentalMaterial3Api::class)

package com.artimesblue.focusflow.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artimesblue.focusflow.R
import com.artimesblue.focusflow.data.Habit
import com.artimesblue.focusflow.data.Goal
import com.artimesblue.focusflow.domain.DashboardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onAdd: () -> Unit,
    onTimer: () -> Unit,
    onReview: () -> Unit,
    onSettings: () -> Unit,
    onAddGoal: () -> Unit,
    onCalendar: () -> Unit
) {
    val vm: DashboardViewModel = viewModel()
    val state by vm.state.collectAsState()
    var showCelebration by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.focusflow_logo),
                            contentDescription = "FocusFlow logo"
                        )
                        Text("FocusFlow")
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(onClick = onAdd) {
                Text("Nieuwe gewoonte")
            }
        }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp).fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = onTimer) { Text("Focus timer") }
                Button(onClick = onReview) { Text("Week review") }
                OutlinedButton(onClick = onSettings) { Text("Instellingen") }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = onAddGoal) { Text("Nieuwe goal") }
                OutlinedButton(onClick = onCalendar) { Text("Kalender") }
            }
            Card(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("XP totaal", style = MaterialTheme.typography.titleMedium)
                    Text(state.totalXp.toString(), style = MaterialTheme.typography.headlineSmall)
                    if (state.xpByCategory.isNotEmpty()) {
                        state.xpByCategory.forEach { (category, xp) ->
                            Text("$category: $xp XP")
                        }
                    } else {
                        Text("Nog geen XP verdiend.")
                    }
                }
            }
            Text("Goals", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            if (state.goals.isEmpty()) {
                Text("Maak je eerste goal om XP te verdienen.")
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    state.goals.forEach { goal ->
                        GoalCard(goal = goal, onComplete = { duration ->
                            vm.completeGoal(goal, duration)
                            showCelebration = true
                        })
                    }
                }
            }
            Text("Vandaag", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            if (state.habits.isEmpty()) {
                Text("Voeg je eerste gewoonte toe met de knop hieronder.")
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(state.habits) { habit ->
                        val currentProgress = state.today.filter { it.habitId == habit.id }.sumOf { it.amount }
                        HabitCard(habit = habit, currentProgress = currentProgress) { amount ->
                            vm.addProgress(habit.id, amount)
                        }
                    }
                }
            }
        }
    }

    if (showCelebration && state.lastCompletionXp != null) {
        AlertDialog(
            onDismissRequest = {
                showCelebration = false
                vm.clearCompletionCelebration()
            },
            confirmButton = {
                TextButton(onClick = {
                    showCelebration = false
                    vm.clearCompletionCelebration()
                }) { Text("Top!") }
            },
            title = { Text("Gefeliciteerd!") },
            text = { Text("Je hebt ${state.lastCompletionXp} XP verdiend!") }
        )
    }
}

@Composable
private fun HabitCard(habit: Habit, currentProgress: Int, onQuickAdd: (Int) -> Unit) {
    val progress = (currentProgress.toFloat() / habit.dailyGoal.toFloat()).coerceIn(0f, 1f)
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp)) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(habit.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    "$currentProgress / ${habit.dailyGoal} ${habit.unit}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Spacer(Modifier.weight(1f))
                val unitText = if (habit.unit.isNotBlank()) " ${habit.unit}" else ""
                listOf(1, 5, 10).forEach { amount ->
                    AssistChip(
                        onClick = { onQuickAdd(amount) },
                        label = { Text("+$amount") },
                        modifier = Modifier.semantics {
                            contentDescription = "Voeg $amount$unitText toe aan ${habit.name}"
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun GoalCard(goal: Goal, onComplete: (Int) -> Unit) {
    var durationText by remember(goal.id) { mutableStateOf(goal.targetMinutes.toString()) }
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(goal.name, style = MaterialTheme.typography.titleMedium)
            Text("Categorie: ${goal.category} • Moeilijkheid: ${goal.difficulty}")
            OutlinedTextField(
                value = durationText,
                onValueChange = { durationText = it },
                label = { Text("Duur (min)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    val duration = durationText.toIntOrNull() ?: goal.targetMinutes
                    onComplete(duration)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Voltooid")
            }
        }
    }
}
