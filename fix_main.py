with open("app/src/main/java/com/artimesblue/focusflow/MainActivity.kt", "r") as f:
    content = f.read()

content = content.replace(
    "registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))",
    "androidx.core.content.ContextCompat.registerReceiver(this, receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE), androidx.core.content.ContextCompat.RECEIVER_EXPORTED)"
)

with open("app/src/main/java/com/artimesblue/focusflow/MainActivity.kt", "w") as f:
    f.write(content)
