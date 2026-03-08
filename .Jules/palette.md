## 2024-03-08 - Keyboard Navigation in Jetpack Compose
**Learning:** For forms in Jetpack Compose, ensuring seamless keyboard navigation requires setting `keyboardOptions` with appropriate `ImeAction` (like `Next` or `Done`) and handling the action explicitly using `keyboardActions` along with `LocalFocusManager` to move or clear focus. Otherwise, users get stuck with the keyboard open.
**Action:** Always verify keyboard options and focus management for text fields in Compose applications.
