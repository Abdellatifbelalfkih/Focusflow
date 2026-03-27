import re

with open('app/src/main/java/com/artimesblue/focusflow/ui/FocusTimerScreen.kt', 'r') as f:
    content = f.read()

# Add semantics import
import_statement = "import androidx.compose.ui.semantics.contentDescription\nimport androidx.compose.ui.semantics.semantics"
content = content.replace("import androidx.compose.ui.Modifier", "import androidx.compose.ui.Modifier\n" + import_statement)

# Fix Slider performance and accessibility
slider_old = """            Slider(value = total / 60f, onValueChange = {
                if (!running) {
                    total = it.toInt() * 60
                    remaining = total
                }
            }, valueRange = 5f..60f, steps = 55)"""

slider_new = """            var sliderValue by remember { mutableStateOf(total / 60f) }
            Slider(
                value = sliderValue,
                onValueChange = {
                    if (!running) {
                        sliderValue = it
                    }
                },
                onValueChangeFinished = {
                    if (!running) {
                        total = sliderValue.toInt() * 60
                        remaining = total
                    }
                },
                valueRange = 5f..60f,
                steps = 55,
                modifier = Modifier.semantics { contentDescription = "Timer duration slider" }
            )"""

content = content.replace(slider_old, slider_new)

# Fix timer cleanup
disposable = """
    DisposableEffect(Unit) {
        onDispose {
            timer?.cancel()
        }
    }
"""
scaffold = "    Scaffold(topBar = { TopAppBar(title = { Text(\"Focus timer\") }) }) { padding ->"
content = content.replace(scaffold, disposable + scaffold)

with open('app/src/main/java/com/artimesblue/focusflow/ui/FocusTimerScreen.kt', 'w') as f:
    f.write(content)
