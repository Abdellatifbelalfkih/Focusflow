import re

with open('app/src/main/java/com/artimesblue/focusflow/ui/AddHabitScreen.kt', 'r') as f:
    content = f.read()

# Add isValid
body_start = content.find("val focusManager = LocalFocusManager.current")
body_end = content.find("\n", body_start) + 1
insert = """    val g = goal.toIntOrNull() ?: 0
    val isValid = name.isNotBlank() && g > 0
"""
content = content[:body_end] + insert + content[body_end:]

# Modify unit keyboard actions
old_unit_done = """val g = goal.toIntOrNull() ?: 0
                    if (name.isNotBlank() && g > 0) {"""
new_unit_done = """if (isValid) {"""
content = content.replace(old_unit_done, new_unit_done)

# Modify button
old_button = """            Button(onClick = {
                val g = goal.toIntOrNull() ?: 0
                if (name.isNotBlank() && g > 0) {
                    vm.addHabit(name, g, unit)
                    onDone()
                }
            }) { Text("Opslaan") }"""
new_button = """            Button(
                onClick = { if (isValid) { vm.addHabit(name, g, unit); onDone() } },
                enabled = isValid
            ) { Text("Opslaan") }"""
content = content.replace(old_button, new_button)

with open('app/src/main/java/com/artimesblue/focusflow/ui/AddHabitScreen.kt', 'w') as f:
    f.write(content)
