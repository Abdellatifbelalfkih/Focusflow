package com.artimesblue.focusflow.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Habit::class, ProgressEntry::class, Goal::class, TaskEntry::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun progressDao(): ProgressDao
    abstract fun goalDao(): GoalDao
    abstract fun taskEntryDao(): TaskEntryDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun get(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "focusflow.db"
                ).fallbackToDestructiveMigration().build().also { INSTANCE = it }
            }
    }
}
