import re

with open('app/src/main/java/com/artimesblue/focusflow/ui/AddGoalScreen.kt', 'r') as f:
    content = f.read()

# Add isValid
body_start = content.find("val focusManager = LocalFocusManager.current")
body_end = content.find("\n", body_start) + 1
insert = """    val isValid = name.isNotBlank()
"""
content = content[:body_end] + insert + content[body_end:]

# Modify button
old_button = """            Button(
                onClick = {
                    if (name.isNotBlank()) {
                        vm.addGoal(name, category, difficulty.toInt(), targetMinutes.toInt())
                        onDone()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Opslaan")
            }"""
new_button = """            Button(
                onClick = { if (isValid) { vm.addGoal(name, category, difficulty.toInt(), targetMinutes.toInt()); onDone() } },
                modifier = Modifier.fillMaxWidth(),
                enabled = isValid
            ) { Text("Opslaan") }"""
content = content.replace(old_button, new_button)

with open('app/src/main/java/com/artimesblue/focusflow/ui/AddGoalScreen.kt', 'w') as f:
    f.write(content)
