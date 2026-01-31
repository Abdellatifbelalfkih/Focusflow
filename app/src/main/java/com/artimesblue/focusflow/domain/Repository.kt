package com.artimesblue.focusflow.domain

import android.content.Context
import com.artimesblue.focusflow.data.*
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class Repository(context: Context) {
    private val db = AppDatabase.get(context)
    private val habits = db.habitDao()
    private val progress = db.progressDao()
    private val goals = db.goalDao()
    private val taskEntries = db.taskEntryDao()

    fun streamHabits(): Flow<List<Habit>> = habits.getAll()
    suspend fun addHabit(name: String, dailyGoal: Int, unit: String) {
        habits.insert(Habit(name = name, dailyGoal = dailyGoal, unit = unit))
    }
    suspend fun addProgress(habitId: Long, amount: Int, date: LocalDate = LocalDate.now()) {
        progress.insert(ProgressEntry(habitId = habitId, amount = amount, date = date.toString()))
    }
    fun streamTodayProgress(): Flow<List<ProgressEntry>> =
        progress.streamForDay(LocalDate.now().toString())

    fun streamGoals(): Flow<List<Goal>> = goals.getAll()

    fun streamTasksForDate(date: LocalDate): Flow<List<TaskEntry>> =
        taskEntries.streamForDay(date.toString())

    suspend fun addGoal(name: String, category: String, difficulty: Int, targetMinutes: Int) {
        goals.insert(
            Goal(
                name = name,
                category = category,
                difficulty = difficulty,
                targetMinutes = targetMinutes,
                createdAt = LocalDate.now().toString()
            )
        )
    }

    suspend fun completeGoal(goalId: Long, durationMinutes: Int, date: LocalDate) {
        taskEntries.insert(
            TaskEntry(
                goalId = goalId,
                durationMinutes = durationMinutes,
                date = date.toString(),
                completed = true
            )
        )
    }
}
