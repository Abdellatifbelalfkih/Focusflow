## 2024-05-24 - AssistChip Accessibility in Habit Lists
**Learning:** Icon-only or short-text buttons (like "+1") in lists lack context for screen readers, making it unclear what is being modified.
**Action:** Always add dynamic `Modifier.semantics { contentDescription = "Voeg [amount] [unit] toe aan [name]" }` to quick-add buttons in lists to provide full context.
