## 2024-05-21 - AssistChip Accessibility in Lists
**Learning:** When using `AssistChip` components in lists (like habit quick-adds), the default label (e.g., "+1") is insufficient for screen readers.
**Action:** Use `Modifier.semantics { contentDescription = ... }` to provide dynamic descriptions that combine the action and the item name (e.g., "Add 1 glass to Water").
