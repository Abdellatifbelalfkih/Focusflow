## 2026-03-16 - Seamless Keyboard Navigation in Jetpack Compose
**Learning:** By default, Jetpack Compose forms do not automatically transition focus to the next input field upon pressing "Next" on the soft keyboard, leading to a fragmented user experience where the user must manually tap each field.
**Action:** Configure `keyboardOptions` with `ImeAction.Next` or `ImeAction.Done`, and handle `keyboardActions` using `LocalFocusManager.current.moveFocus(FocusDirection.Next)` (or `.clearFocus()`) to enable smooth, uninterrupted keyboard navigation between text inputs.
