import re

with open('app/src/main/java/com/artimesblue/focusflow/ui/FocusTimerScreen.kt', 'r') as f:
    content = f.read()

# Fix reset button to also update sliderValue
reset_old = """TextButton(onClick = { remaining = total }) { Text("Reset") }"""
reset_new = """TextButton(onClick = { remaining = total; sliderValue = total / 60f }) { Text("Reset") }"""
content = content.replace(reset_old, reset_new)

with open('app/src/main/java/com/artimesblue/focusflow/ui/FocusTimerScreen.kt', 'w') as f:
    f.write(content)
