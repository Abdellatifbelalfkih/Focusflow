package com.artimesblue.focusflow.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artimesblue.focusflow.data.Habit
import com.artimesblue.focusflow.domain.DashboardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onAdd: () -> Unit,
    onTimer: () -> Unit,
    onReview: () -> Unit,
    onSettings: () -> Unit
) {
    val vm: DashboardViewModel = viewModel()
    val state by vm.state.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("FocusFlow") }) },
        floatingActionButton = {
            ExtendedFloatingActionButton(onClick = onAdd) {
                Text("Nieuwe gewoonte")
            }
        }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp).fillMaxSize()) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = onTimer) { Text("Focus timer") }
                Button(onClick = onReview) { Text("Week review") }
                OutlinedButton(onClick = onSettings) { Text("Instellingen") }
            }
            Spacer(Modifier.height(16.dp))
            Text("Vandaag", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
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
}

@Composable
private fun HabitCard(habit: Habit, currentProgress: Int, onQuickAdd: (Int) -> Unit) {
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(habit.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "$currentProgress / ${habit.dailyGoal} ${habit.unit}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = { (currentProgress.toFloat() / habit.dailyGoal.toFloat()).coerceIn(0f, 1f) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Spacer(Modifier.weight(1f))
                AssistChip(onClick = { onQuickAdd(1) }, label = { Text("+1") })
                AssistChip(onClick = { onQuickAdd(5) }, label = { Text("+5") })
                AssistChip(onClick = { onQuickAdd(10) }, label = { Text("+10") })
            }
        }
    }
}
