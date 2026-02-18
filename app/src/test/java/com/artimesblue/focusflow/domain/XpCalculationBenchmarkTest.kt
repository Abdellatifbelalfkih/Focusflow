package com.artimesblue.focusflow.domain

import com.artimesblue.focusflow.data.Goal
import com.artimesblue.focusflow.data.TaskEntry
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.system.measureNanoTime

class XpCalculationBenchmarkTest {

    private fun baseline(goals: List<Goal>, tasks: List<TaskEntry>): Pair<Map<String, Int>, Int> {
        val goalMap = goals.associateBy { it.id }
        val xpByCategory = tasks.filter { it.completed }.fold(mutableMapOf<String, Int>()) { acc, task ->
            val goal = goalMap[task.goalId]
            val category = goal?.category ?: "Overig"
            val xp = (goal?.difficulty ?: 1) * task.durationMinutes
            acc[category] = (acc[category] ?: 0) + xp
            acc
        }
        val totalXp = xpByCategory.values.sum()
        return xpByCategory to totalXp
    }

    private fun optimized(goalMap: Map<Long, Goal>, tasks: List<TaskEntry>): Pair<Map<String, Int>, Int> {
        val xpByCategory = mutableMapOf<String, Int>()
        var totalXp = 0

        for (task in tasks) {
            if (task.completed) {
                val goal = goalMap[task.goalId]
                val category = goal?.category ?: "Overig"
                val xp = (goal?.difficulty ?: 1) * task.durationMinutes

                xpByCategory[category] = (xpByCategory[category] ?: 0) + xp
                totalXp += xp
            }
        }
        return xpByCategory to totalXp
    }

    @Test
    fun benchmark() {
        val goals = (1..1000).map {
            Goal(
                id = it.toLong(),
                name = "Goal $it",
                category = if (it % 2 == 0) "Work" else "Personal",
                difficulty = (it % 5) + 1,
                targetMinutes = 30,
                createdAt = "2023-01-01"
            )
        }
        val tasks = (1..5000).map {
            TaskEntry(
                id = it.toLong(),
                goalId = (it % 1000 + 1).toLong(),
                date = "2023-01-01",
                durationMinutes = 30,
                completed = it % 2 == 0 // 50% completed
            )
        }

        // Warmup
        val precomputedMap = goals.associateBy { it.id }
        repeat(50) {
            baseline(goals, tasks)
            optimized(precomputedMap, tasks)
        }

        // Measurement
        var baselineTime = 0L
        var optimizedTime = 0L
        val iterations = 100

        repeat(iterations) {
            baselineTime += measureNanoTime {
                baseline(goals, tasks)
            }
            optimizedTime += measureNanoTime {
                optimized(precomputedMap, tasks)
            }
        }

        val avgBaseline = baselineTime / iterations
        val avgOptimized = optimizedTime / iterations

        println("Baseline average time: ${avgBaseline / 1000} us")
        println("Optimized average time: ${avgOptimized / 1000} us")

        // Correctness check
        val (baseMap, baseTotal) = baseline(goals, tasks)
        val (optMap, optTotal) = optimized(precomputedMap, tasks)

        assertEquals(baseTotal, optTotal)
        assertEquals(baseMap, optMap)

        assertTrue("Optimized version should be faster", avgOptimized < avgBaseline)
    }
}
