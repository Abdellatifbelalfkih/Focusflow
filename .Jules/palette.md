## 2024-05-22 - Context for Quick Actions
**Learning:** Generic 'quick add' buttons (like +1, +5) are meaningless to screen readers without context.
**Action:** always wrap `AssistChip` or similar small actions in `Modifier.semantics { contentDescription = "..." }` that combines the action (Add 1) with the object (Habit Name).
