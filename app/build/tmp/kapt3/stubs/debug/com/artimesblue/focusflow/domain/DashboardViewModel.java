package com.artimesblue.focusflow.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007J\u001e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0015J\u0016\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020!2\u0006\u0010\'\u001a\u00020\u000bR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006("}, d2 = {"Lcom/artimesblue/focusflow/domain/DashboardViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "lastCompletionXp", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "repo", "Lcom/artimesblue/focusflow/domain/Repository;", "selectedDate", "Ljava/time/LocalDate;", "kotlin.jvm.PlatformType", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/artimesblue/focusflow/domain/DashboardState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "addGoal", "Lkotlinx/coroutines/Job;", "name", "", "category", "difficulty", "targetMinutes", "addHabit", "dailyGoal", "unit", "addProgress", "habitId", "", "amount", "clearCompletionCelebration", "", "completeGoal", "goal", "Lcom/artimesblue/focusflow/data/Goal;", "durationMinutes", "selectDate", "date", "app_debug"})
public final class DashboardViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.artimesblue.focusflow.domain.Repository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.time.LocalDate> selectedDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> lastCompletionXp = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.artimesblue.focusflow.domain.DashboardState> state = null;

    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }

    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.artimesblue.focusflow.domain.DashboardState> getState() {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addHabit(@org.jetbrains.annotations.NotNull()
    java.lang.String name, int dailyGoal, @org.jetbrains.annotations.NotNull()
    java.lang.String unit) {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addProgress(long habitId, int amount) {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addGoal(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String category, int difficulty, int targetMinutes) {
        return null;
    }

    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job completeGoal(@org.jetbrains.annotations.NotNull()
    com.artimesblue.focusflow.data.Goal goal, int durationMinutes) {
        return null;
    }

    public final void selectDate(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate date) {
    }

    public final void clearCompletionCelebration() {
    }
}