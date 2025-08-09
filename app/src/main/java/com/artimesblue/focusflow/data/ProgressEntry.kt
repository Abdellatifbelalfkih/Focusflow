package com.artimesblue.focusflow.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "progress_entries")
data class ProgressEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val habitId: Long,
    val date: String, // YYYY-MM-DD
    val amount: Int
)