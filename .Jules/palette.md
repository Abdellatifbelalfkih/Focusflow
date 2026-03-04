## 2024-05-14 - Compose Quick Action Accessibility
**Learning:** Compose `AssistChip` and similar quick-action chips with text like "+1" or icon-only buttons need explicit, localized `contentDescription` semantics to be useful for screen reader users, especially when they refer to dynamic items in a list.
**Action:** Use `Modifier.semantics { contentDescription = ... }` with localized context (e.g., "Voeg [amount] [unit] toe aan [name]") for all list item action chips.

## 2024-05-14 - LinearProgressIndicator Deprecation in Material3
**Learning:** Material3's `LinearProgressIndicator`'s direct `Float` progress parameter is deprecated due to potential performance issues during recomposition; it now prefers a lambda `progress = { value }`.
**Action:** Always use the lambda overload `progress = { value }` for `LinearProgressIndicator` components.
