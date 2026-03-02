
## 2024-05-24 - Accessibility labels for AssistChips in lists
**Learning:** AssistChip components used in lists often lack context for screen readers when they only contain generic amounts like "+1".
**Action:** Use `Modifier.semantics { contentDescription = ... }` to provide dynamic, localized descriptions (e.g., 'Voeg 1 min toe aan Lezen') combining the action, unit, and item name.
