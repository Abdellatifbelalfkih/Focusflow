## 2024-05-22 - Dynamic Content Descriptions for Repeated Lists
**Learning:** When using repeated actions (like "+1", "+5") in a list of items (habits), default text labels are insufficient for screen readers as they don't provide context (which habit?).
**Action:** Always wrap repeated action components in `Modifier.semantics { contentDescription = "..." }` that includes the item name (e.g., "Voeg 1 toe aan [Habit Name]").
