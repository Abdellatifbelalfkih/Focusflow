## 2024-05-27 - [Add Keyboard Accessibility to Form Screens]
**Learning:** Adding keyboard support (`ImeAction.Next`, `FocusDirection.Down`/`Next`) to Jetpack Compose form inputs significantly improves accessibility, enabling a smooth, intuitive keyboard navigation experience instead of requiring manual touch selection for each field.
**Action:** Always configure `KeyboardOptions` and `KeyboardActions` with `LocalFocusManager` in multi-input Compose forms to enable seamless field-to-field keyboard navigation.
