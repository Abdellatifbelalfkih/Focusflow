import re

file_path = "app/src/main/java/com/artimesblue/focusflow/ui/AddHabitScreen.kt"

with open(file_path, "r") as f:
    content = f.read()

# Add imports
imports = """import androidx.compose.ui.text.input.ImeAction
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType"""

content = re.sub(
    r"import androidx.compose.foundation.text.KeyboardOptions\nimport androidx.compose.ui.text.input.KeyboardType",
    imports,
    content
)

# Add LocalFocusManager to Composable
content = re.sub(
    r"var unit by remember \{ mutableStateOf\(\"min\"\) \}",
    "var unit by remember { mutableStateOf(\"min\") }\n    val focusManager = LocalFocusManager.current",
    content
)

# Update TextField 1
content = re.sub(
    r"OutlinedTextField\(\n\s+value = name, onValueChange = \{ name = it \},\n\s+label = \{ Text\(\"Naam\"\) \}, modifier = Modifier.fillMaxWidth\(\)\n\s+\)",
    """OutlinedTextField(
                value = name, onValueChange = { name = it },
                label = { Text("Naam") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                modifier = Modifier.fillMaxWidth()
            )""",
    content
)

# Update TextField 2
content = re.sub(
    r"keyboardOptions = KeyboardOptions\(keyboardType = KeyboardType.Number\),",
    "keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),",
    content
)

# Update TextField 3
content = re.sub(
    r"OutlinedTextField\(\n\s+value = unit, onValueChange = \{ unit = it \},\n\s+label = \{ Text\(\"Eenheid \(bijv. min, reps\)\"\) \}, modifier = Modifier.fillMaxWidth\(\)\n\s+\)",
    """OutlinedTextField(
                value = unit, onValueChange = { unit = it },
                label = { Text("Eenheid (bijv. min, reps)") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                modifier = Modifier.fillMaxWidth()
            )""",
    content
)

with open(file_path, "w") as f:
    f.write(content)
