package com.artimesblue.focusflow.update

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

private const val PREFS_NAME = "focusflow_updates"
private const val PREF_DOWNLOAD_ID = "download_id"

class UpdateManager(private val context: Context) {
    data class UpdateInfo(
        val versionName: String,
        val downloadUrl: String
    )

    fun checkForUpdate(): UpdateInfo? {
        val currentVersion = context.packageManager
            .getPackageInfo(context.packageName, 0)
            .versionName
            ?.trim()
            ?: return null

        val releaseJson = fetchLatestReleaseJson() ?: return null
        val tag = releaseJson.optString("tag_name").trim()
        val latestVersion = tag.removePrefix("v").ifBlank { return null }

        if (!isNewerVersion(latestVersion, currentVersion)) {
            return null
        }

        val assets = releaseJson.optJSONArray("assets") ?: return null
        for (i in 0 until assets.length()) {
            val asset = assets.getJSONObject(i)
            val name = asset.optString("name")
            val downloadUrl = asset.optString("browser_download_url")
            if (name.endsWith(".apk", ignoreCase = true) && downloadUrl.isNotBlank()) {
                return UpdateInfo(versionName = latestVersion, downloadUrl = downloadUrl)
            }
        }

        return null
    }

    fun enqueueDownload(updateInfo: UpdateInfo): Long {
        val request = DownloadManager.Request(Uri.parse(updateInfo.downloadUrl))
            .setTitle("FocusFlow update ${updateInfo.versionName}")
            .setDescription("Downloaden van de nieuwste versie")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(
                Environment.DIRECTORY_DOWNLOADS,
                "focusflow-${updateInfo.versionName}.apk"
            )

        val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val downloadId = manager.enqueue(request)
        storeDownloadId(downloadId)
        return downloadId
    }

    fun getStoredDownloadId(): Long =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getLong(PREF_DOWNLOAD_ID, -1L)

    fun clearStoredDownloadId() {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit()
            .remove(PREF_DOWNLOAD_ID)
            .apply()
    }

    private fun storeDownloadId(downloadId: Long) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit()
            .putLong(PREF_DOWNLOAD_ID, downloadId)
            .apply()
    }

    fun getDownloadedApkUri(downloadId: Long): Uri? {
        val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        return manager.getUriForDownloadedFile(downloadId)
    }

    private fun fetchLatestReleaseJson(): JSONObject? {
        return try {
            val url = URL("https://api.github.com/repos/Abdellatifbelalfkih/Focusflow/releases/latest")
            val connection = (url.openConnection() as HttpURLConnection).apply {
                connectTimeout = 10_000
                readTimeout = 10_000
                setRequestProperty("Accept", "application/vnd.github+json")
            }
            if (connection.responseCode !in 200..299) return null
            connection.inputStream.use { stream ->
                val body = stream.bufferedReader().readText()
                JSONObject(body)
            }
        } catch (_: Exception) {
            null
        }
    }

    private fun isNewerVersion(latest: String, current: String): Boolean {
        val latestParts = latest.split(".").mapNotNull { it.toIntOrNull() }
        val currentParts = current.split(".").mapNotNull { it.toIntOrNull() }
        val maxLength = maxOf(latestParts.size, currentParts.size)
        for (index in 0 until maxLength) {
            val latestPart = latestParts.getOrElse(index) { 0 }
            val currentPart = currentParts.getOrElse(index) { 0 }
            if (latestPart != currentPart) {
                return latestPart > currentPart
            }
        }
        return false
    }
}
