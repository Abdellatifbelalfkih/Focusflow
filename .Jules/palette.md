## 2024-03-17 - Keyboard Accessibility in Compose Forms
**Learning:** By default, Android Compose text fields (`OutlinedTextField`) do not advance focus nicely between inputs using the keyboard (e.g., using "Next" or "Done" on the on-screen keyboard, or Tab key). This breaks accessibility and smooth UX, especially in data entry screens like `AddHabitScreen`.
**Action:** Use `keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)` and `keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })` for intermediate inputs, and `ImeAction.Done` for the final input. Provide `LocalFocusManager.current` to manage this state.

## 2024-03-17 - Dynamic Accessibility Descriptions in Compose Lists
**Learning:** Using default `contentDescription` for repeated actions like `AssistChip` showing "+1", "+5", etc., provides insufficient context for screen reader users (they just hear "+1 button", not knowing which item it applies to).
**Action:** Use string resources with format args (e.g., `Add %1$d to %2$s`) combined with `Modifier.semantics { contentDescription = context.getString(R.string.add_to_habit, amount, habit.name) }` to provide dynamic, informative descriptions for icon/shortcut buttons in list items.
