## 2024-03-19 - [Form Accessibility via Keyboard Options]
**Learning:** Adding correct keyboard IME options and actions significantly improves form accessibility for users relying on screen readers or software keyboards. Form screens in Compose missing `keyboardOptions` with `ImeAction.Next` or `Done` lead to clunky navigation.
**Action:** When working on form screens in Compose, always configure `keyboardOptions` with `ImeAction.Next` or `Done` and handle `keyboardActions` via `LocalFocusManager` to enable seamless keyboard navigation.
