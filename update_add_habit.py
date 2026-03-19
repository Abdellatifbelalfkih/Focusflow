import re

file_path = "app/src/main/java/com/artimesblue/focusflow/ui/AddHabitScreen.kt"

with open(file_path, "r") as f:
    content = f.read()

imports_to_add = """
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.focus.FocusDirection
"""

# Add imports
content = content.replace("import androidx.compose.foundation.text.KeyboardOptions\n", "import androidx.compose.foundation.text.KeyboardOptions\n" + imports_to_add.strip() + "\n")

# Add focus manager
content = content.replace(
    "var unit by remember { mutableStateOf(\"min\") }",
    "var unit by remember { mutableStateOf(\"min\") }\n    val focusManager = LocalFocusManager.current"
)

# Update first OutlinedTextField
content = content.replace(
    """            OutlinedTextField(
                value = name, onValueChange = { name = it },
                label = { Text("Naam") }, modifier = Modifier.fillMaxWidth()
            )""",
    """            OutlinedTextField(
                value = name, onValueChange = { name = it },
                label = { Text("Naam") }, modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) })
            )"""
)

# Update second OutlinedTextField
content = content.replace(
    """            OutlinedTextField(
                value = goal, onValueChange = { goal = it },
                label = { Text("Dagdoel") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )""",
    """            OutlinedTextField(
                value = goal, onValueChange = { goal = it },
                label = { Text("Dagdoel") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) }),
                modifier = Modifier.fillMaxWidth()
            )"""
)

# Update third OutlinedTextField
content = content.replace(
    """            OutlinedTextField(
                value = unit, onValueChange = { unit = it },
                label = { Text("Eenheid (bijv. min, reps)") }, modifier = Modifier.fillMaxWidth()
            )""",
    """            OutlinedTextField(
                value = unit, onValueChange = { unit = it },
                label = { Text("Eenheid (bijv. min, reps)") }, modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                    val g = goal.toIntOrNull() ?: 0
                    if (name.isNotBlank() && g > 0) {
                        vm.addHabit(name, g, unit)
                        onDone()
                    }
                })
            )"""
)

with open(file_path, "w") as f:
    f.write(content)
