## 2024-05-15 - Palette initialized\n**Learning:** Initializing journal.\n**Action:** Create file.
## 2026-03-11 - Dynamic Accessibility Labels for Icon Buttons
**Learning:** When using components like AssistChip for quick actions, screen readers may just read out the text label (e.g., '+1') without context, causing a poor accessibility experience. Using `Modifier.semantics { contentDescription = context.getString(...) }` provides essential context.
**Action:** Add descriptive ARIA-equivalent labels (contentDescriptions) for all icon or brief-text action buttons in Jetpack Compose, localized via Android string resources.
