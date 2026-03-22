
## 2024-05-15 - [Add ImeAction and KeyboardActions to Form Screens]
**Learning:** Providing explicit `ImeAction` (e.g., Next, Done) and defining `KeyboardActions` with a `LocalFocusManager` in form screens makes the application significantly more accessible and navigable via both on-screen and hardware keyboards, avoiding the need for users to repeatedly tap to move focus.
**Action:** Always configure `keyboardOptions` and `keyboardActions` for text fields in forms so that users can seamlessly tab/next through fields and submit the form with 'Done'.
