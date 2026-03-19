with open("app/src/main/java/com/artimesblue/focusflow/ui/DashboardScreen.kt", "r") as f:
    content = f.read()

import re
pattern = r"<<<<<<< HEAD.*?=======(.*?)>>>>>>> theirs"

def repl(match):
    return """import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape"""

new_content = re.sub(pattern, repl, content, flags=re.DOTALL)

with open("app/src/main/java/com/artimesblue/focusflow/ui/DashboardScreen.kt", "w") as f:
    f.write(new_content)
