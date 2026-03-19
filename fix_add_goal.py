with open("app/src/main/java/com/artimesblue/focusflow/ui/AddGoalScreen.kt", "r") as f:
    content = f.read()

imports = """
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.focus.FocusDirection
"""
content = content.replace("import androidx.compose.ui.Modifier\n", "import androidx.compose.ui.Modifier\n" + imports)

content = content.replace("var expanded by remember { mutableStateOf(false) }", "var expanded by remember { mutableStateOf(false) }\n    val focusManager = LocalFocusManager.current")

content = content.replace(
    """            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Naam") },
                modifier = Modifier.fillMaxWidth()
            )""",
    """            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Naam") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) })
            )"""
)

with open("app/src/main/java/com/artimesblue/focusflow/ui/AddGoalScreen.kt", "w") as f:
    f.write(content)
