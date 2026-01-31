package com.artimesblue.focusflow.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_entries")
data class TaskEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val goalId: Long,
    val date: String,
    val durationMinutes: Int,
    val completed: Boolean
)
