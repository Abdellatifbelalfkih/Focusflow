## 2024-05-24 - Add AssistChip accessibility
**Learning:** Icon-only or generic "+1", "+5" buttons lack context for screen readers. Using `Modifier.semantics { contentDescription = context.getString(...) }` dynamically binds the value to the specific habit name, giving much better context.
**Action:** Always provide dynamically bound content descriptions to `AssistChip` actions inside lists.

## 2024-05-24 - Keyboard Navigation on Forms
**Learning:** Android Compose users with keyboards expect seamless progression. Setting `ImeAction.Next` and binding it via `keyboardActions` using `LocalFocusManager.current.moveFocus(FocusDirection.Next)` creates a much smoother flow than defaulting to the standard enter key behavior.
**Action:** Ensure multi-field forms in Compose use explicit keyboard navigation options.
