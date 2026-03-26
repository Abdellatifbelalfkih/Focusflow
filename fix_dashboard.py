with open("app/src/main/java/com/artimesblue/focusflow/ui/DashboardScreen.kt", "r") as f:
    content = f.read()

import re
content = re.sub(r'<<<<<<< HEAD.*?=======', 'import androidx.compose.ui.res.painterResource\nimport androidx.compose.ui.draw.clip\nimport androidx.compose.foundation.shape.RoundedCornerShape\n=======', content, flags=re.DOTALL)
content = re.sub(r'=======.*?>>>>>>> 581a3ab1464d099f6f410996da9d2cd58a64843f', '', content, flags=re.DOTALL)

with open("app/src/main/java/com/artimesblue/focusflow/ui/DashboardScreen.kt", "w") as f:
    f.write(content)
