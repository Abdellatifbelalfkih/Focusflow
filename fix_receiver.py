import re

with open('app/src/main/java/com/artimesblue/focusflow/MainActivity.kt', 'r') as f:
    content = f.read()

import_statement = "import androidx.core.content.ContextCompat"
content = content.replace("import android.content.IntentFilter", "import android.content.IntentFilter\n" + import_statement)

old_register = "registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))"
new_register = "ContextCompat.registerReceiver(this, receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE), ContextCompat.RECEIVER_EXPORTED)"
content = content.replace(old_register, new_register)

with open('app/src/main/java/com/artimesblue/focusflow/MainActivity.kt', 'w') as f:
    f.write(content)
