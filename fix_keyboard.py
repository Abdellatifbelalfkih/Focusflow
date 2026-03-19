with open("app/src/main/java/com/artimesblue/focusflow/ui/DashboardScreen.kt", "r") as f:
    content = f.read()

content = content.replace("import androidx.compose.ui.text.input.KeyboardOptions", "import androidx.compose.foundation.text.KeyboardOptions")

with open("app/src/main/java/com/artimesblue/focusflow/ui/DashboardScreen.kt", "w") as f:
    f.write(content)
