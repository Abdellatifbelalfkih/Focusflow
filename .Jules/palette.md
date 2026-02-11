## 2024-06-25 - Improving accessibility for AssistChips in lists
**Learning:** When using `AssistChip` components in lists, the label alone (e.g., "+1") is often insufficient for screen reader users, as it lacks context.
**Action:** Use `Modifier.semantics { contentDescription = ... }` to provide a dynamic accessibility description that combines the action (e.g., "Add 1 unit") with the item name (e.g., "to Habit Name").
