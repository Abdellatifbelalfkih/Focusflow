## 2024-05-18 - Keyboard Navigation UX for Forms
**Learning:** Adding keyboard support to form inputs by explicitly specifying `keyboardOptions` with `ImeAction.Next` or `ImeAction.Done` and hooking up `keyboardActions` to `LocalFocusManager` makes data entry much faster and more accessible.
**Action:** Implemented form navigation for the Add Habit screen, allowing users to tab through Name -> Goal -> Unit and submit cleanly with the keyboard without moving hands back to touch screen/mouse.
