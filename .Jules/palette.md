## 2024-05-22 - Semantic Descriptions for Action Chips
**Learning:** Repetitive action chips (like "+1", "+5") in a list context are ambiguous to screen readers without explicit associations.
**Action:** Use `Modifier.semantics { contentDescription = "..." }` to dynamically combine the action, amount, unit, and item name (e.g., "Voeg 1 minuten toe aan Lezen").
