package com.artimesblue.focusflow.update;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\nJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/artimesblue/focusflow/update/UpdateManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkForUpdate", "Lcom/artimesblue/focusflow/update/UpdateManager$UpdateInfo;", "clearStoredDownloadId", "", "enqueueDownload", "", "updateInfo", "fetchLatestReleaseJson", "Lorg/json/JSONObject;", "getDownloadedApkUri", "Landroid/net/Uri;", "downloadId", "getStoredDownloadId", "isNewerVersion", "", "latest", "", "current", "storeDownloadId", "UpdateInfo", "app_debug"})
public final class UpdateManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;

    public UpdateManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }

    @org.jetbrains.annotations.Nullable()
    public final com.artimesblue.focusflow.update.UpdateManager.UpdateInfo checkForUpdate() {
        return null;
    }

    public final long enqueueDownload(@org.jetbrains.annotations.NotNull()
    com.artimesblue.focusflow.update.UpdateManager.UpdateInfo updateInfo) {
        return 0L;
    }

    public final long getStoredDownloadId() {
        return 0L;
    }

    public final void clearStoredDownloadId() {
    }

    private final void storeDownloadId(long downloadId) {
    }

    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getDownloadedApkUri(long downloadId) {
        return null;
    }

    private final org.json.JSONObject fetchLatestReleaseJson() {
        return null;
    }

    private final boolean isNewerVersion(java.lang.String latest, java.lang.String current) {
        return false;
    }

    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/artimesblue/focusflow/update/UpdateManager$UpdateInfo;", "", "versionName", "", "downloadUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getDownloadUrl", "()Ljava/lang/String;", "getVersionName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class UpdateInfo {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String versionName = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String downloadUrl = null;

        public UpdateInfo(@org.jetbrains.annotations.NotNull()
        java.lang.String versionName, @org.jetbrains.annotations.NotNull()
        java.lang.String downloadUrl) {
            super();
        }

        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVersionName() {
            return null;
        }

        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDownloadUrl() {
            return null;
        }

        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }

        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }

        @org.jetbrains.annotations.NotNull()
        public final com.artimesblue.focusflow.update.UpdateManager.UpdateInfo copy(@org.jetbrains.annotations.NotNull()
        java.lang.String versionName, @org.jetbrains.annotations.NotNull()
        java.lang.String downloadUrl) {
            return null;
        }

        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }

        @java.lang.Override()
        public int hashCode() {
            return 0;
        }

        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}