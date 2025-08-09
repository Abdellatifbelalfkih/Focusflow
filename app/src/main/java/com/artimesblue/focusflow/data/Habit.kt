package com.artimesblue.focusflow.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class Habit(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val dailyGoal: Int, // units per day, e.g. minutes or reps
    val unit: String // e.g. "min", "reps", "pages"
)