import re
with open("app/src/main/java/com/artimesblue/focusflow/ui/DashboardScreen.kt", "r") as f:
    lines = f.readlines()

new_lines = []
for line in lines:
    if line.startswith("<<<<<<< HEAD"):
        continue
    if line.startswith("<<<<<<< ours"):
        continue
    if line.startswith("======="):
        continue
    if line.startswith(">>>>>>>"):
        continue
    if line.startswith("import androidx.compose.ui.res.painterResource"):
        if "import androidx.compose.ui.res.painterResource\n" not in new_lines:
             new_lines.append(line)
        continue
    new_lines.append(line)

with open("app/src/main/java/com/artimesblue/focusflow/ui/DashboardScreen.kt", "w") as f:
    f.writelines(new_lines)
