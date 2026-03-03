## 2025-03-03 - AssistChip Accessibility in Lists
**Learning:** Screen readers typically read just the literal text ("+1", "+5") for `AssistChip` components, which loses the vital context of what is being added and to what habit when used in a `LazyColumn` list.
**Action:** Use `Modifier.semantics { contentDescription = ... }` on `AssistChip` inside lists to provide full dynamic context localized to Dutch, e.g. "Voeg 1 minuut toe aan Meditatie".
