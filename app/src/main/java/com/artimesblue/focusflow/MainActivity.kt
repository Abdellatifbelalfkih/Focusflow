package com.artimesblue.focusflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.artimesblue.focusflow.ui.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val nav = rememberNavController()
                NavHost(navController = nav, startDestination = "dashboard") {
                    composable("dashboard") { DashboardScreen(
                        onAdd = { nav.navigate("addHabit") },
                        onTimer = { nav.navigate("timer") },
                        onReview = { nav.navigate("review") },
                        onSettings = { nav.navigate("settings") }
                    ) }
                    composable("addHabit") { AddHabitScreen(onDone = { nav.popBackStack() }) }
                    composable("timer") { FocusTimerScreen(onBack = { nav.popBackStack() }) }
                    composable("settings") { SettingsScreen(onBack = { nav.popBackStack() }) }
                    composable("review") { WeeklyReviewScreen(onBack = { nav.popBackStack() }) }
                }
            }
        }
    }
}