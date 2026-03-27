import re

with open('app/src/main/java/com/artimesblue/focusflow/ui/AddHabitScreen.kt', 'r') as f:
    content = f.read()

# Add imports
imports = """import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.focus.FocusDirection"""
content = content.replace("import androidx.compose.foundation.text.KeyboardOptions", imports)

# Add focusManager
body_start = content.find("var unit by remember")
body_end = content.find("\n", body_start) + 1
insert = """    val focusManager = LocalFocusManager.current
"""
content = content[:body_end] + insert + content[body_end:]

# Modify OutlinedTextFields
content = content.replace(
    'label = { Text("Naam") }, modifier = Modifier.fillMaxWidth()',
    'label = { Text("Naam") }, modifier = Modifier.fillMaxWidth(),\n                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),\n                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })'
)

content = content.replace(
    'keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),',
    'keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),\n                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),'
)

old_unit = """label = { Text("Eenheid (bijv. min, reps)") }, modifier = Modifier.fillMaxWidth()"""
new_unit = """label = { Text("Eenheid (bijv. min, reps)") }, modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                    val g = goal.toIntOrNull() ?: 0
                    if (name.isNotBlank() && g > 0) {
                        vm.addHabit(name, g, unit)
                        onDone()
                    }
                })"""
content = content.replace(old_unit, new_unit)

with open('app/src/main/java/com/artimesblue/focusflow/ui/AddHabitScreen.kt', 'w') as f:
    f.write(content)
