package com.artimesblue.focusflow.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException
import kotlin.random.Random

@RunWith(RobolectricTestRunner::class)
class ProgressEntryBenchmarkTest {

    private lateinit var db: AppDatabase
    private lateinit var progressDao: ProgressDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).allowMainThreadQueries().build()
        progressDao = db.progressDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun benchmarkQueryPerformance() = runBlocking {
        // 1. Insert Data
        val habitIds = (1L..10L).toList()

        val entries = mutableListOf<ProgressEntry>()
        // Generate 1000 days of data for each habit
        for (habitId in habitIds) {
            for (day in 1..1000) {
                 val dateStr = "2023-${(day / 30 + 1).toString().padStart(2, '0')}-${(day % 28 + 1).toString().padStart(2, '0')}"
                 entries.add(
                     ProgressEntry(
                         habitId = habitId,
                         date = dateStr,
                         amount = Random.nextInt(100)
                     )
                 )
            }
        }

        println("Inserting ${entries.size} entries...")
        val startInsert = System.nanoTime()
        // Use a transaction for faster inserts if possible, but DAO doesn't expose it.
        // We can use db.runInTransaction if we want speed, but individual inserts are fine for setup.
        db.runInTransaction {
            runBlocking {
                for (entry in entries) {
                    progressDao.insert(entry)
                }
            }
        }
        val endInsert = System.nanoTime()
        println("Insertion took: ${(endInsert - startInsert) / 1_000_000} ms")

        // 2. Measure Query Performance
        val targetHabitId = 5L
        val targetDate = "2023-05-15"

        // Warmup
        progressDao.getForDay(targetHabitId, targetDate)

        val iterations = 2000
        val startQuery = System.nanoTime()
        for (i in 0 until iterations) {
            progressDao.getForDay(targetHabitId, targetDate)
        }
        val endQuery = System.nanoTime()
        val avgTime = (endQuery - startQuery) / iterations

        println("BENCHMARK_RESULT: Average Query Time for getForDay: ${avgTime} ns")
        println("BENCHMARK_RESULT: Total time for $iterations queries: ${(endQuery - startQuery) / 1_000_000} ms")
    }
}
