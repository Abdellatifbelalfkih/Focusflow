package com.artimesblue.focusflow.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0017J&\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u001bJ(\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00152\b\b\u0002\u0010 \u001a\u00020!H\u0086@\u00a2\u0006\u0002\u0010\"J&\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0086@\u00a2\u0006\u0002\u0010\"J\u0012\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0\'J\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0(0\'J\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0(0\'2\u0006\u0010 \u001a\u00020!J\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0(0\'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/artimesblue/focusflow/domain/Repository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "db", "Lcom/artimesblue/focusflow/data/AppDatabase;", "goals", "Lcom/artimesblue/focusflow/data/GoalDao;", "habits", "Lcom/artimesblue/focusflow/data/HabitDao;", "progress", "Lcom/artimesblue/focusflow/data/ProgressDao;", "taskEntries", "Lcom/artimesblue/focusflow/data/TaskEntryDao;", "addGoal", "", "name", "", "category", "difficulty", "", "targetMinutes", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addHabit", "dailyGoal", "unit", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addProgress", "habitId", "", "amount", "date", "Ljava/time/LocalDate;", "(JILjava/time/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeGoal", "goalId", "durationMinutes", "streamGoals", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/artimesblue/focusflow/data/Goal;", "streamHabits", "Lcom/artimesblue/focusflow/data/Habit;", "streamTasksForDate", "Lcom/artimesblue/focusflow/data/TaskEntry;", "streamTodayProgress", "Lcom/artimesblue/focusflow/data/ProgressEntry;", "app_debug"})
public final class Repository {
    @org.jetbrains.annotations.NotNull()
    private final com.artimesblue.focusflow.data.AppDatabase db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.artimesblue.focusflow.data.HabitDao habits = null;
    @org.jetbrains.annotations.NotNull()
    private final com.artimesblue.focusflow.data.ProgressDao progress = null;
    @org.jetbrains.annotations.NotNull()
    private final com.artimesblue.focusflow.data.GoalDao goals = null;
    @org.jetbrains.annotations.NotNull()
    private final com.artimesblue.focusflow.data.TaskEntryDao taskEntries = null;

    public Repository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }

    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.artimesblue.focusflow.data.Habit>> streamHabits() {
        return null;
    }

    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addHabit(@org.jetbrains.annotations.NotNull()
    java.lang.String name, int dailyGoal, @org.jetbrains.annotations.NotNull()
    java.lang.String unit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }

    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addProgress(long habitId, int amount, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.artimesblue.focusflow.data.ProgressEntry>> streamTodayProgress() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.artimesblue.focusflow.data.Goal>> streamGoals() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.artimesblue.focusflow.data.TaskEntry>> streamTasksForDate(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate date) {
        return null;
    }

    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addGoal(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String category, int difficulty, int targetMinutes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }

    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object completeGoal(long goalId, int durationMinutes, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}