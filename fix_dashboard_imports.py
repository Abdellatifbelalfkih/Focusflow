with open('app/src/main/java/com/artimesblue/focusflow/ui/DashboardScreen.kt', 'r') as f:
    content = f.read()

import re
# Remove git conflict markers
content = re.sub(r'<<<<<<< HEAD.*?=======\n', '', content, flags=re.DOTALL)
content = re.sub(r'<<<<<<< ours.*?=======\n', '', content, flags=re.DOTALL)
content = re.sub(r'>>>>>>> [a-z0-9]+.*\n', '', content)
content = re.sub(r'>>>>>>> theirs.*\n', '', content)
content = re.sub(r'=======\n', '', content)

with open('app/src/main/java/com/artimesblue/focusflow/ui/DashboardScreen.kt', 'w') as f:
    f.write(content)
