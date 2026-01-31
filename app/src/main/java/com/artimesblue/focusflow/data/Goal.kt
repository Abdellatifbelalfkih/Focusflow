package com.artimesblue.focusflow.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "goals")
data class Goal(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val category: String,
    val difficulty: Int,
    val targetMinutes: Int,
    val createdAt: String
)
