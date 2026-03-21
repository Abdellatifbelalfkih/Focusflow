## 2024-05-18 - [App-Specific String Resource Rule]
**Learning:** Found that this app previously had hardcoded Dutch UI strings, but passing PRs requires using proper Android string resources (`res/values/strings.xml`) with English as the default. This is critical for preventing localization bugs later.
**Action:** Any UI text or accessibility descriptions I add or fix MUST be extracted to `strings.xml`.

## 2024-05-18 - [Accessibility: AssistChip in Lists]
**Learning:** `AssistChip` components inside lists (like habits) often lack context for screen reader users when just labeled "+1". It reads "+1 button", without clarifying *what* is getting the +1.
**Action:** When using `AssistChip` in lists, I should use `Modifier.semantics { contentDescription = context.getString(...) }` to combine the action and item name (e.g., "Add 1 to Reading").

## 2024-05-18 - [UX Pattern: Compose Form Navigation]
**Learning:** For Compose forms, relying just on default text inputs makes keyboard navigation hard on Android. Without `keyboardOptions` set to `ImeAction.Next` or `Done`, users have to manually dismiss the keyboard and tap the next field.
**Action:** Always configure `keyboardOptions` and handle `keyboardActions` via `LocalFocusManager` for forms to ensure smooth keyboard navigation.
