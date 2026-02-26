## 2024-05-23 - Keyboard Navigation in Compose Forms
**Learning:** Users often get stuck on forms without explicit keyboard actions (Next/Done). Adding `ImeAction.Next` and `ImeAction.Done` along with `focusManager.moveFocus(FocusDirection.Down)` significantly improves form usability and flow, especially on mobile where keyboard obscures content.
**Action:** Always configure `keyboardOptions` and `keyboardActions` for `OutlinedTextField`s in forms, using `LocalFocusManager` to control focus flow.

## 2024-05-23 - Android 14 Broadcast Receiver Security
**Learning:** `registerReceiver` requires `RECEIVER_EXPORTED` or `RECEIVER_NOT_EXPORTED` flag for non-system broadcasts on Android 14 (SDK 34). Using `ContextCompat.registerReceiver` handles compatibility, but lint may be strict about constants.
**Action:** Use `ContextCompat.registerReceiver` with explicit flags for all dynamic receiver registrations to avoid security crashes on newer Android versions.
