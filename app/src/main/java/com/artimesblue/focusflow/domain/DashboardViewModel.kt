package com.artimesblue.focusflow.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.artimesblue.focusflow.data.Goal
import com.artimesblue.focusflow.data.Habit
import com.artimesblue.focusflow.data.ProgressEntry
import com.artimesblue.focusflow.data.TaskEntry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate

data class DashboardState(
    val habits: List<Habit> = emptyList(),
    val today: List<ProgressEntry> = emptyList(),
    val goals: List<Goal> = emptyList(),
    val tasks: List<TaskEntry> = emptyList(),
    val selectedDate: LocalDate = LocalDate.now(),
    val totalXp: Int = 0,
    val xpByCategory: Map<String, Int> = emptyMap(),
    val lastCompletionXp: Int? = null
)

private data class DashboardSource(
    val habits: List<Habit>,
    val today: List<ProgressEntry>,
    val goals: List<Goal>,
    val date: LocalDate,
    val completionXp: Int?
)

class DashboardViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = Repository(app)
    private val selectedDate = MutableStateFlow(LocalDate.now())
    private val lastCompletionXp = MutableStateFlow<Int?>(null)

    val state: StateFlow<DashboardState> =
        combine(
            repo.streamHabits(),
            repo.streamTodayProgress(),
            repo.streamGoals(),
            selectedDate,
            lastCompletionXp
        ) { habits, today, goals, date, completionXp ->
            DashboardSource(habits, today, goals, date, completionXp)
        }.combine(
            selectedDate.flatMapLatest { repo.streamTasksForDate(it) }
        ) { source, tasks ->
            val goalMap = source.goals.associateBy { it.id }
            val xpByCategory = tasks.filter { it.completed }.fold(mutableMapOf<String, Int>()) { acc, task ->
                val goal = goalMap[task.goalId]
                val category = goal?.category ?: "Overig"
                val xp = (goal?.difficulty ?: 1) * task.durationMinutes
                acc[category] = (acc[category] ?: 0) + xp
                acc
            }
            val totalXp = xpByCategory.values.sum()
            DashboardState(
                habits = source.habits,
                today = source.today,
                goals = source.goals,
                tasks = tasks,
                selectedDate = source.date,
                totalXp = totalXp,
                xpByCategory = xpByCategory,
                lastCompletionXp = source.completionXp
            )
        }
            .stateIn(viewModelScope, SharingStarted.Eagerly, DashboardState())

    fun addHabit(name: String, dailyGoal: Int, unit: String) = viewModelScope.launch {
        repo.addHabit(name, dailyGoal, unit)
    }

    fun addProgress(habitId: Long, amount: Int) = viewModelScope.launch {
        repo.addProgress(habitId, amount)
    }

    fun addGoal(name: String, category: String, difficulty: Int, targetMinutes: Int) = viewModelScope.launch {
        repo.addGoal(name, category, difficulty, targetMinutes)
    }

    fun completeGoal(goal: Goal, durationMinutes: Int) = viewModelScope.launch {
        repo.completeGoal(goal.id, durationMinutes, selectedDate.value)
        lastCompletionXp.value = goal.difficulty * durationMinutes
    }

    fun selectDate(date: LocalDate) {
        selectedDate.value = date
    }

    fun clearCompletionCelebration() {
        lastCompletionXp.value = null
    }
}
