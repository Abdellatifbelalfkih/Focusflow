package com.artimesblue.focusflow.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.artimesblue.focusflow.data.Habit
import com.artimesblue.focusflow.data.ProgressEntry
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class DashboardState(
    val habits: List<Habit> = emptyList(),
    val today: List<ProgressEntry> = emptyList()
)

class DashboardViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = Repository(app)

    val state: StateFlow<DashboardState> =
        kotlinx.coroutines.flow.combine(
            repo.streamHabits(),
            repo.streamTodayProgress()
        ) { habits, today -> DashboardState(habits, today) }
            .stateIn(viewModelScope, SharingStarted.Eagerly, DashboardState())

    fun addHabit(name: String, dailyGoal: Int, unit: String) = viewModelScope.launch {
        repo.addHabit(name, dailyGoal, unit)
    }

    fun addProgress(habitId: Long, amount: Int) = viewModelScope.launch {
        repo.addProgress(habitId, amount)
    }
}