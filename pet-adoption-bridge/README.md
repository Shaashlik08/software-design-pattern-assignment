# Pet Adoption Documents (Bridge)

## Description

A small Java console app that issues pet adoption documents (certificate, vaccination report)
in different formats (plain text, HTML). Implemented with the **Bridge** structural pattern.

Without Bridge, every combination of *document type* x *format* would need its own class
(`HtmlCertificate`, `PlainTextCertificate`, `HtmlVaccinationReport`, ...) = 2 x 2 = 4 classes, and every new
format would add a class for each document. With Bridge the two hierarchies grow independently: 2 + 2 = 4 classes
now, but adding a 3rd format costs 1 class instead of 2 (and with 10 documents, 1 instead of 10).

## Pattern Roles

| Role | Class | Responsibility |
| --- | --- | --- |
| Abstraction | `AdoptionDocument` (abstract class) | Knows WHAT a document consists of; holds a reference to the Implementor |
| Refined Abstraction | `AdoptionCertificate`, `VaccinationReport` | Concrete document content (title, fields, footer note) |
| Implementor | `DocumentRenderer` (interface) | Low-level operations: `renderHeader`, `renderField`, `renderFooter` |
| Concrete Implementor | `PlainTextRenderer`, `HtmlRenderer` | Knows HOW to draw each piece in one format |
| Client | `Main` | Composes a document with a renderer and switches it at runtime via `setRenderer(...)` |

```
AdoptionDocument  <>------------------>  DocumentRenderer
   ^        ^                                 ^          ^
   |        |                                 |          |
Certificate Report                       PlainText      Html
```

## Project Structure

- `AdoptionDocument.java` - Abstraction (template of rendering, delegates drawing to the renderer)
- `AdoptionCertificate.java`, `VaccinationReport.java` - Refined Abstractions
- `DocumentRenderer.java` - Implementor interface
- `PlainTextRenderer.java`, `HtmlRenderer.java` - Concrete Implementors
- `Main.java` - Client: switching implementors, using several abstractions with the same implementors, validation failures

## How to Run

```bash
javac *.java
java Main
```

## Clean Code Principles Applied

### 1. Clear separation of abstraction side vs. implementation side
Document classes never contain formatting symbols (`<h1>`, `====`), and renderers never know what a
certificate or a vaccination report is. The client only calls `render()` and `setRenderer()`, so no renderer
details leak into it.

### 2. Meaningful names that distinguish the roles
Abstraction side is named after the domain (`AdoptionDocument`, `AdoptionCertificate`), implementation side
after the technique (`DocumentRenderer`, `HtmlRenderer`). Methods say what they do: `renderHeader`,
`renderField`, `getFooterNote`.

### 3. Small, focused classes on both sides
Each class has one reason to change. `VaccinationReport` changes only if the report content changes;
`HtmlRenderer` changes only if the HTML output changes. Every method is a few lines long.

### 4. No duplicated logic between Concrete Implementors
The order of rendering (header -> fields -> footer) lives only once in `AdoptionDocument.render()`.
Renderers implement only formatting of one piece, so none of them repeats iteration or document structure.

### 5. Backward-compatible design (Open/Closed)
Adding a new format (e.g. `MarkdownRenderer`) means adding one class that implements `DocumentRenderer`.
`AdoptionDocument` and its subclasses are not touched. Likewise, a new document type is a new subclass
and no renderer changes.

### 6. Validation in one place, fail fast
Constructors reject empty names, empty vaccine lists, and `null` renderers with clear messages
(`requireText` is shared by all documents), so an invalid document can never be created.

### 7. No magic values
Values with a meaning are named: `TITLE_UNDERLINE` in `PlainTextRenderer`.
