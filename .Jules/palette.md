## 2026-03-12 - Keyboard Navigation in Compose Forms
**Learning:** Forms in Compose without explicit `ImeAction` and focus management create a frustrating experience where users must manually tap each field and hide the keyboard.
**Action:** Always configure `keyboardOptions` with `ImeAction.Next` or `ImeAction.Done` and handle `keyboardActions` via `LocalFocusManager` for seamless keyboard navigation between form fields.
