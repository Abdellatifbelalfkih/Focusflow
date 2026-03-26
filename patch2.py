import re

with open("app/src/main/java/com/artimesblue/focusflow/ui/AddHabitScreen.kt", "r") as f:
    content = f.read()

# remove duplicates
content = content.replace("""import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.focus.FocusDirection""", """import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.focus.FocusDirection""")

content = content.replace("""    val focusManager = LocalFocusManager.current
    val focusManager = LocalFocusManager.current""", """    val focusManager = LocalFocusManager.current""")

content = content.replace("""    val submitAction = {
        val g = goal.toIntOrNull() ?: 0
        if (name.isNotBlank() && g > 0) {
            vm.addHabit(name, g, unit)
            onDone()
        }
    }


    val submitAction = {
        val g = goal.toIntOrNull() ?: 0
        if (name.isNotBlank() && g > 0) {
            vm.addHabit(name, g, unit)
            onDone()
        }
    }""", """    val submitAction = {
        val g = goal.toIntOrNull() ?: 0
        if (name.isNotBlank() && g > 0) {
            vm.addHabit(name, g, unit)
            onDone()
        }
    }""")

with open("app/src/main/java/com/artimesblue/focusflow/ui/AddHabitScreen.kt", "w") as f:
    f.write(content)
