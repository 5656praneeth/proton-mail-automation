# Proton Mail Selenium Java Framework

This project is a Selenium + Java + TestNG automation framework for Proton Mail. The codebase is built using the Page Object Model and contains shared utilities for browser setup, waits, frame switching, and reusable page interactions.

## What is covered
- Login flow
- Compose and send email flow
- Draft handling
- Inbox actions
- Search flow
- Settings/filter related page objects
- Attachment and async test coverage
- Browser lifecycle and failure handling

## Tech stack
- Java 17
- Maven
- Selenium 4
- TestNG
- Page Object Model

## Important frame handling detail
One key issue in Proton Mail is that the editor body sits inside an iframe. This project includes frame switching helpers in the shared base page and element action layer:

- `switchToFrame(String frameId)`
- `switchToFrame(By by)`

This is used when the message body is a `contenteditable` element inside the Proton inbox frame.

## Project structure
- `src/test/java/com/qa/base` – base test setup
- `src/test/java/com/qa/config` – configuration reader
- `src/test/java/com/qa/driver` – driver factory and browser setup
- `src/test/java/com/qa/listeners` – listeners and failure handling
- `src/test/java/com/qa/pages` – page objects for Login, Inbox, Compose, Drafts, Search, Settings
- `src/test/java/com/qa/tests` – functional test classes
- `src/test/java/com/qa/utils` – waits, element actions, helpers
- `src/test/resources` – config and test fixtures
- `docs` – architecture and defect templates
- `test-cases` – test inventory

## Setup
### Prerequisites
- JDK 17+
- Maven 3.9+
- Chrome, Firefox, or Edge

### Configuration
Set credentials in `src/test/resources/config.properties` or use environment variables for your Proton test accounts.

Do not commit real credentials to Git.

## Run tests
```bash
mvn clean test
mvn clean test -Dbrowser=chrome -Dheadless=true
mvn clean test -Dbrowser=firefox -Dheadless=true
mvn clean test -Dbrowser=edge -Dheadless=true
```

## Notes
- Some locators are still marked as `VERIFY` and should be checked against the live DOM before being treated as final.
- Proton Mail selectors and frame structure may change, so stable waits and probing are important.
- Use dedicated test mailboxes and avoid production or personal data.

## Repository hygiene
- `target/` and IDE generated files are ignored via `.gitignore`
- Keep credentials local and out of Git
- Keep only real project source, tests, and documentation in the repo

## Current status
This repository contains the Selenium automation framework structure, shared page utilities, and the Proton Mail frame-handling approach used in this project. The next step is live DOM validation and completing the end-to-end test execution with real Proton UI data.

