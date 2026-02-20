## 2024-05-22 - Contextual AssistChips
**Learning:** Icon-only or short-text AssistChips (like "+1") are meaningless to screen readers without context. They need dynamic content descriptions that include the unit and subject (e.g., "Add 1 minute to Meditation").
**Action:** Always wrap `AssistChip` or similar controls in `Modifier.semantics` with a full sentence description when the label is abbreviated.
