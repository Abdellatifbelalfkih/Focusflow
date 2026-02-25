## 2024-05-22 - Form Accessibility
**Learning:** This app's forms (AddHabitScreen, AddGoalScreen) consistently lack keyboard navigation support (ImeAction.Next/Done), forcing users to manually dismiss the keyboard.
**Action:** Systematically check all form screens for `KeyboardOptions` and add explicit navigation actions via `LocalFocusManager`.
