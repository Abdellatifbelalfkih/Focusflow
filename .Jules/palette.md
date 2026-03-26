
## 2024-05-28 - Keyboard Navigation in Compose Forms
**Learning:** For multi-field forms in Jetpack Compose, users expect seamless keyboard navigation to move between fields without reaching for the screen. Standard `TextField`s do not provide this automatically.
**Action:** Always configure `keyboardOptions` with `ImeAction.Next` or `ImeAction.Done` and handle `keyboardActions` via `LocalFocusManager.current.moveFocus(FocusDirection.Next)` or `.clearFocus()` to enable intuitive keyboard navigation.
