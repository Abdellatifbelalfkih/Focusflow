## 2024-05-27 - Dynamic Accessibility Descriptions for List Item Actions
**Learning:** Screen reader users lose context when encountering multiple generic action buttons (e.g., "+1", "+5") in a list of items like habits. The generic labels don't explain *which* item the action applies to.
**Action:** When adding actions to list items (e.g., using `AssistChip`), always provide a dynamic accessibility description using `Modifier.semantics { contentDescription = context.getString(R.string.action_format, value, item.name) }`.
