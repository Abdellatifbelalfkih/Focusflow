@file:OptIn(ExperimentalMaterial3Api::class)

package com.artimesblue.focusflow.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artimesblue.focusflow.domain.DashboardViewModel
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CalendarScreen(onBack: () -> Unit) {
    val vm: DashboardViewModel = viewModel()
    val state by vm.state.collectAsState()
    val today = LocalDate.now()
    val days = (0L..6L).map { today.minusDays(6 - it) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Kalender") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Terug")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            Modifier.padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Selecteer een dag", style = MaterialTheme.typography.titleMedium)
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(days) { date ->
                    val isSelected = date == state.selectedDate
                    FilterChip(
                        selected = isSelected,
                        onClick = { vm.selectDate(date) },
                        label = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()))
                                Text(date.dayOfMonth.toString())
                            }
                        }
                    )
                }
            }
            Text("Voltooide taken", style = MaterialTheme.typography.titleMedium)
            if (state.tasks.isEmpty()) {
                Text("Nog geen taken voltooid op deze dag.")
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    state.tasks.forEach { task ->
                        val goal = state.goals.firstOrNull { it.id == task.goalId }
                        Card(Modifier.fillMaxWidth()) {
                            Column(Modifier.padding(12.dp)) {
                                Text(goal?.name ?: "Onbekende goal", style = MaterialTheme.typography.titleMedium)
                                Text("Duur: ${task.durationMinutes} min • XP: ${(goal?.difficulty ?: 1) * task.durationMinutes}")
                            }
                        }
                    }
                }
            }
        }
    }
}
