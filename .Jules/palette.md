## 2024-06-18 - Accessibility in Repeated Lists
**Learning:** `AssistChip` and other icon-only or short-text buttons inside lists (like `LazyColumn`) need explicit context in their accessibility descriptions. A simple "+1" is confusing without knowing *what* is being added to.
**Action:** Use `Modifier.semantics { contentDescription = ... }` to combine the action (+1) with the item name (Habit Name) for a complete sentence: "Voeg 1 [unit] toe aan [name]".
