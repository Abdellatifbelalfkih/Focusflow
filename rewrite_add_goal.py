import re

with open('app/src/main/java/com/artimesblue/focusflow/ui/AddGoalScreen.kt', 'r') as f:
    content = f.read()

# Add imports
imports = """import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.focus.FocusDirection"""
content = content.replace("import androidx.compose.ui.Modifier", "import androidx.compose.ui.Modifier\n" + imports)

# Add focusManager
body_start = content.find("var expanded by remember")
body_end = content.find("\n", body_start) + 1
insert = """    val focusManager = LocalFocusManager.current
"""
content = content[:body_end] + insert + content[body_end:]

# Modify OutlinedTextFields
content = content.replace(
    'label = { Text("Naam") },\n                modifier = Modifier.fillMaxWidth()',
    'label = { Text("Naam") },\n                modifier = Modifier.fillMaxWidth(),\n                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),\n                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })'
)

with open('app/src/main/java/com/artimesblue/focusflow/ui/AddGoalScreen.kt', 'w') as f:
    f.write(content)
