## 2024-05-24 - AssistChip Accessibility in Lists
**Learning:** `AssistChip` components used for quick actions (like "+1", "+5") inside list items lack context for screen readers, announcing only the label.
**Action:** Always wrap `AssistChip` or similar icon-heavy buttons in list items with `Modifier.semantics { contentDescription = "..." }` to include the item name and action context (e.g., "Add 1 unit to [Habit Name]").
