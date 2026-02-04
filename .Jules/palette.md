## 2024-05-23 - Accessibility in Lists
**Learning:** When using AssistChip components in lists, the default label is often insufficient for screen reader context (e.g., '+1' doesn't say what is being added to).
**Action:** Always add dynamic contentDescription combining the action and item name (e.g., 'Add 1 to [Item Name]') via semantics modifier.
