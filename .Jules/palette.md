## 2024-05-24 - Form Keyboard Navigation
**Learning:** Adding KeyboardOptions and KeyboardActions for `ImeAction.Next` and `ImeAction.Done` makes forms significantly more accessible and usable.
**Action:** Always configure `keyboardOptions` with `ImeAction.Next` or `Done` and handle `keyboardActions` via `LocalFocusManager` in Compose forms.
