package com.artimesblue.focusflow.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Query("SELECT * FROM habits ORDER BY id DESC")
    fun getAll(): Flow<List<Habit>>

    @Insert
    suspend fun insert(habit: Habit): Long

    @Delete
    suspend fun delete(habit: Habit)
}

@Dao
interface ProgressDao {
    @Query("SELECT * FROM progress_entries WHERE habitId = :habitId AND date = :date")
    suspend fun getForDay(habitId: Long, date: String): List<ProgressEntry>

    @Query("SELECT * FROM progress_entries WHERE date = :date")
    fun streamForDay(date: String): Flow<List<ProgressEntry>>

    @Insert
    suspend fun insert(entry: ProgressEntry): Long
}

@Dao
interface GoalDao {
    @Query("SELECT * FROM goals ORDER BY id DESC")
    fun getAll(): Flow<List<Goal>>

    @Insert
    suspend fun insert(goal: Goal): Long
}

@Dao
interface TaskEntryDao {
    @Query("SELECT * FROM task_entries WHERE date = :date")
    fun streamForDay(date: String): Flow<List<TaskEntry>>

    @Insert
    suspend fun insert(taskEntry: TaskEntry): Long
}
