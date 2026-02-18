package com.artimesblue.focusflow.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\u0010\u0015J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\fH\u00c6\u0003J\t\u0010*\u001a\u00020\u000eH\u00c6\u0003J\u0015\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010H\u00c6\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0015\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0010H\u00c6\u0003J\u009a\u0001\u0010.\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0010H\u00c6\u0001\u00a2\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\u000eH\u00d6\u0001J\t\u00104\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019\u00a8\u00065"}, d2 = {"Lcom/artimesblue/focusflow/domain/DashboardState;", "", "habits", "", "Lcom/artimesblue/focusflow/data/Habit;", "today", "Lcom/artimesblue/focusflow/data/ProgressEntry;", "goals", "Lcom/artimesblue/focusflow/data/Goal;", "tasks", "Lcom/artimesblue/focusflow/data/TaskEntry;", "selectedDate", "Ljava/time/LocalDate;", "totalXp", "", "xpByCategory", "", "", "lastCompletionXp", "habitProgress", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/time/LocalDate;ILjava/util/Map;Ljava/lang/Integer;Ljava/util/Map;)V", "getGoals", "()Ljava/util/List;", "getHabitProgress", "()Ljava/util/Map;", "getHabits", "getLastCompletionXp", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSelectedDate", "()Ljava/time/LocalDate;", "getTasks", "getToday", "getTotalXp", "()I", "getXpByCategory", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/time/LocalDate;ILjava/util/Map;Ljava/lang/Integer;Ljava/util/Map;)Lcom/artimesblue/focusflow/domain/DashboardState;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class DashboardState {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.artimesblue.focusflow.data.Habit> habits = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.artimesblue.focusflow.data.ProgressEntry> today = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.artimesblue.focusflow.data.Goal> goals = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.artimesblue.focusflow.data.TaskEntry> tasks = null;
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDate selectedDate = null;
    private final int totalXp = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Integer> xpByCategory = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer lastCompletionXp = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.Long, java.lang.Integer> habitProgress = null;

    public DashboardState(@org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.Habit> habits, @org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.ProgressEntry> today, @org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.Goal> goals, @org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.TaskEntry> tasks, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate selectedDate, int totalXp, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Integer> xpByCategory, @org.jetbrains.annotations.Nullable()
    java.lang.Integer lastCompletionXp, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Long, java.lang.Integer> habitProgress) {
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
    public final java.util.List<com.artimesblue.focusflow.data.TaskEntry> getTasks() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getSelectedDate() {
        return null;
    }

    public final int getTotalXp() {
        return 0;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Integer> getXpByCategory() {
        return null;
    }

    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getLastCompletionXp() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Long, java.lang.Integer> getHabitProgress() {
        return null;
    }

    public DashboardState() {
        super();
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
    public final java.util.List<com.artimesblue.focusflow.data.TaskEntry> component4() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate component5() {
        return null;
    }

    public final int component6() {
        return 0;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Integer> component7() {
        return null;
    }

    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Long, java.lang.Integer> component9() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final com.artimesblue.focusflow.domain.DashboardState copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.Habit> habits, @org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.ProgressEntry> today, @org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.Goal> goals, @org.jetbrains.annotations.NotNull()
    java.util.List<com.artimesblue.focusflow.data.TaskEntry> tasks, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate selectedDate, int totalXp, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Integer> xpByCategory, @org.jetbrains.annotations.Nullable()
    java.lang.Integer lastCompletionXp, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Long, java.lang.Integer> habitProgress) {
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