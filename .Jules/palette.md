## 2024-05-23 - AssistChip Accessibility in Lists
**Learning:** `AssistChip`s in a list need explicit content descriptions when their label is generic (e.g., "+1"). Without it, screen readers can't distinguish between multiple "+1" buttons for different items.
**Action:** Use `Modifier.semantics { contentDescription = "..." }` to combine the action and the item name for clear context.
