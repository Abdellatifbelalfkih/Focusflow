## 2026-03-15 - Accessibility Descriptions for Quick Action Buttons
**Learning:** Using generic numbers like "+1" on list item quick action buttons (e.g., AssistChip components) creates an ambiguous experience for screen reader users, as the action lacks context about what is being added and to which item.
**Action:** When creating quick action buttons in lists, always use Modifier.semantics { contentDescription = context.getString(...) } to combine the action, value, unit, and item name into a clear, localized description (e.g., "Add 1 min to Reading").
