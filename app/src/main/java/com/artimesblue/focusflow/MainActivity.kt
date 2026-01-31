package com.artimesblue.focusflow

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.artimesblue.focusflow.ui.*
import com.artimesblue.focusflow.update.UpdateManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private var downloadReceiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val updateManager = UpdateManager(this)
        registerDownloadReceiver(updateManager)
        lifecycleScope.launch(Dispatchers.IO) {
            if (updateManager.getStoredDownloadId() != -1L) return@launch
            val updateInfo = updateManager.checkForUpdate() ?: return@launch
            updateManager.enqueueDownload(updateInfo)
        }
        setContent {
            MaterialTheme {
                val nav = rememberNavController()
                NavHost(navController = nav, startDestination = "dashboard") {
                    composable("dashboard") { DashboardScreen(
                        onAdd = { nav.navigate("addHabit") },
                        onTimer = { nav.navigate("timer") },
                        onReview = { nav.navigate("review") },
                        onSettings = { nav.navigate("settings") },
                        onAddGoal = { nav.navigate("addGoal") },
                        onCalendar = { nav.navigate("calendar") }
                    ) }
                    composable("addHabit") { AddHabitScreen(onDone = { nav.popBackStack() }) }
                    composable("addGoal") { AddGoalScreen(onDone = { nav.popBackStack() }) }
                    composable("timer") { FocusTimerScreen(onBack = { nav.popBackStack() }) }
                    composable("settings") { SettingsScreen(onBack = { nav.popBackStack() }) }
                    composable("review") { WeeklyReviewScreen(onBack = { nav.popBackStack() }) }
                    composable("calendar") { CalendarScreen(onBack = { nav.popBackStack() }) }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        downloadReceiver?.let { unregisterReceiver(it) }
    }

    private fun registerDownloadReceiver(updateManager: UpdateManager) {
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                if (intent.action != DownloadManager.ACTION_DOWNLOAD_COMPLETE) return
                val downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1L)
                if (downloadId == -1L || downloadId != updateManager.getStoredDownloadId()) return
                val apkUri = updateManager.getDownloadedApkUri(downloadId) ?: return
                val installIntent = Intent(Intent.ACTION_VIEW).apply {
                    setDataAndType(apkUri, "application/vnd.android.package-archive")
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }
                updateManager.clearStoredDownloadId()
                context.startActivity(installIntent)
            }
        }
        registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
        downloadReceiver = receiver
    }
}
