package com.artimesblue.focusflow.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BU\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nH\u00c6\u0003J\t\u0010 \u001a\u00020\rH\u00c6\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012Jj\u0010\"\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001\u00a2\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020\u000fH\u00d6\u0001J\t\u0010(\u001a\u00020)H\u00d6\u0001R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019\u00a8\u0006*"}, d2 = {"Lcom/artimesblue/focusflow/domain/DashboardSource;", "", "habits", "", "Lcom/artimesblue/focusflow/data/Habit;", "today", "Lcom/artimesblue/focusflow/data/ProgressEntry;", "goals", "Lcom/artimesblue/focusflow/data/Goal;", "goalMap", "", "", "date", "Ljava/time/LocalDate;", "completionXp", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/time/LocalDate;Ljava/lang/Integer;)V", "getCompletionXp", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDate", "()Ljava/time/LocalDate;", "getGoalMap", "()Ljava/util/Map;", "getGoals", "()Ljava/util/List;", "getHabits", "getToday", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/time/LocalDate;Ljava/lang/Integer;)Lcom/artimesblue/focusflow/domain/DashboardSource;", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
final class DashboardSource {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.artimesblue.focusflow.data.Habit> habits = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.artimesblue.focusflow.data.ProgressEntry> today = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.artimesblue.focusflow.data.Goal> goals = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.Long, com.artimesblue.focusflow.data.Goal> goalMap = null;
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDate date = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer completionXp = null;

    public DashboardSource(@org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.Habit> habits, @org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.ProgressEntry> today, @org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.Goal> goals, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Long, com.artimesblue.focusflow.data.Goal> goalMap, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, @org.jetbrains.annotations.Nullable()
    java.lang.Integer completionXp) {
        super();
    }

    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.artimesblue.focusflow.data.Habit> getHabits() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.artimesblue.focusflow.data.ProgressEntry> getToday() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.artimesblue.focusflow.data.Goal> getGoals() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Long, com.artimesblue.focusflow.data.Goal> getGoalMap() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getDate() {
        return null;
    }

    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCompletionXp() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.artimesblue.focusflow.data.Habit> component1() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.artimesblue.focusflow.data.ProgressEntry> component2() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.artimesblue.focusflow.data.Goal> component3() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Long, com.artimesblue.focusflow.data.Goal> component4() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate component5() {
        return null;
    }

    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final com.artimesblue.focusflow.domain.DashboardSource copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.Habit> habits, @org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.ProgressEntry> today, @org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.Goal> goals, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Long, com.artimesblue.focusflow.data.Goal> goalMap, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, @org.jetbrains.annotations.Nullable()
    java.lang.Integer completionXp) {
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