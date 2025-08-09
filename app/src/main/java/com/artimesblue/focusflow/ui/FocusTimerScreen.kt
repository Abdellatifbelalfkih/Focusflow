package com.artimesblue.focusflow.ui

import android.os.CountDownTimer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FocusTimerScreen(onBack: () -> Unit) {
    var total by remember { mutableStateOf(25 * 60) } // seconds
    var remaining by remember { mutableStateOf(total) }
    var running by remember { mutableStateOf(false) }
    var timer: CountDownTimer? by remember { mutableStateOf(null) }

    fun stopTimer() {
        timer?.cancel()
        running = false
    }
    fun startTimer() {
        stopTimer()
        timer = object : CountDownTimer((remaining * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) { remaining = (millisUntilFinished / 1000).toInt() }
            override fun onFinish() { running = false }
        }.start()
        running = true
    }

    Scaffold(topBar = { TopAppBar(title = { Text("Focus timer") }) }) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            Text("Duur (min)")
            Slider(value = total / 60f, onValueChange = {
                if (!running) {
                    total = it.toInt() * 60
                    remaining = total
                }
            }, valueRange = 5f..60f, steps = 55)
            Spacer(Modifier.height(16.dp))
            Text("Resterend: %02d:%02d".format(remaining/60, remaining%60), style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(enabled = !running, onClick = { startTimer() }) { Text("Start") }
                OutlinedButton(enabled = running, onClick = { stopTimer() }) { Text("Stop") }
                TextButton(onClick = { remaining = total }) { Text("Reset") }
            }
        }
    }
}