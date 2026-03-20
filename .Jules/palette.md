## 2024-03-20 - [Accessibility] Dynamic Content Descriptions in Lists
**Learning:** When using components like `AssistChip` in lists (e.g., "+1", "+5"), screen readers need more context than just the action text. Without it, users hear "+1" without knowing what item it applies to.
**Action:** Always combine the action text and the item name in a localized string resource (e.g., "Add 1 to Read book") and apply it using `Modifier.semantics { contentDescription = ... }`.
