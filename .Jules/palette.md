## 2024-05-24 - Contextual content descriptions for Quick Add buttons
**Learning:** AssistChips containing only numeric values ("+1", "+5") present a severe accessibility barrier for screen reader users in list scenarios (like habits), as they provide no context about what is being added or to which item.
**Action:** Always add `Modifier.semantics { contentDescription = "..." }` to generic quick-action buttons in lists, interpolating both the action unit and the list item name (e.g. "Voeg 1 [unit] toe aan [habit name]").
