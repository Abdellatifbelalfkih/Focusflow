

## 2024-05-17 - Dynamic Accessibility Descriptions for Repeated List Items
**Learning:** Screen readers reading out only the text label (e.g. "+1", "+5") for actions in a list are ambiguous when multiple items have identical actions. This can be especially confusing for cognitive accessibility.
**Action:** When using `AssistChip` or similar components in lists, use `Modifier.semantics { contentDescription = context.getString(...) }` to provide dynamic accessibility descriptions combining the action and item name (e.g. "Add 1 to Reading").
