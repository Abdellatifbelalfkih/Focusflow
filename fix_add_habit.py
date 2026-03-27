import re

with open('app/src/main/java/com/artimesblue/focusflow/ui/AddHabitScreen.kt', 'r') as f:
    content = f.read()

content = content.replace("moveDirection(FocusDirection.Down)", "moveFocus(FocusDirection.Down)")

with open('app/src/main/java/com/artimesblue/focusflow/ui/AddHabitScreen.kt', 'w') as f:
    f.write(content)
