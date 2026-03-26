with open("app/src/main/java/com/artimesblue/focusflow/ui/DashboardScreen.kt", "r") as f:
    lines = f.readlines()

for i, line in enumerate(lines):
    if "import androidx.compose.ui.res.painterResource" in line and "import androidx.compose.ui.draw.clip" not in "".join(lines):
        lines.insert(i+1, "import androidx.compose.ui.draw.clip\nimport androidx.compose.foundation.shape.RoundedCornerShape\n")
        break

with open("app/src/main/java/com/artimesblue/focusflow/ui/DashboardScreen.kt", "w") as f:
    f.writelines(lines)
