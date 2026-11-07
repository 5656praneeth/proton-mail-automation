# Proton Mail Web – Selenium + Java Automation

## Scope
Maven + Java 17 + Selenium 4 + TestNG + Page Object Model. The project structure covers the assessment's eight areas: authentication, compose/send, drafts, inbox actions, search, filters, asynchronous behavior and attachments. It also includes test-case inventory, architecture and defect templates, plus failure screenshot capture.

## Important before running
This is a framework starter, not a claim that Proton's current UI has been fully inspected. Proton may use changing selectors, custom controls, iframes, shadow DOM, CAPTCHA or two-factor authentication. Inspect the live DOM using browser developer tools and replace every `VERIFY` locator / placeholder assertion. Do not automate or bypass CAPTCHA/2FA. Use dedicated test mailboxes and non-sensitive test data.

## Prerequisites
- JDK 17+
- Maven 3.9+
- Chrome, Firefox or Edge
- Two Proton test accounts if validating sender-to-receiver delivery

Selenium Manager can resolve browser drivers in supported environments. If your environment requires a managed driver, configure it according to your organization policy.

## Configure credentials
Set environment variables (recommended):
- `SENDER_EMAIL`
- `SENDER_PASSWORD`
- `RECEIVER_EMAIL`
- `RECEIVER_PASSWORD`

Or fill `src/test/resources/config.properties` locally. Never commit real credentials. For CI, use repository secrets.

## Run
```bash
mvn clean test
mvn clean test -Dbrowser=chrome -Dheadless=true
mvn clean test -Dbrowser=firefox -Dheadless=true
mvn clean test -Dbrowser=edge -Dheadless=true
```

## Project layout
- `.github` – GitHub automation, workflow metadata and repo tooling
- `src/test/java/com/qa/driver` – browser lifecycle
- `src/test/java/com/qa/config` – configuration reader
- `src/test/java/com/qa/base` – test setup/teardown
- `src/test/java/com/qa/pages` – Page Object Model
- `src/test/java/com/qa/utils` – waits and element actions
- `src/test/java/com/qa/tests` – test classes by functional area
- `src/test/java/com/qa/listeners` – failure screenshots
- `src/test/resources` – config and test fixtures
- `test-cases` – assessment test inventory
- `docs` – defect and architecture templates
- `target` – generated Maven build artifacts (ignored by Git via `.gitignore`)

## Repository hygiene
- `target/` and IDE folders are excluded from Git via `.gitignore`.
- Keep credentials in environment variables or local config files, never in source control.
- Only commit real project source and test assets; generated output should stay out of the repo.

## Reliability approach
- Implicit wait disabled; explicit waits used for state transitions.
- Avoid arbitrary `Thread.sleep`.
- Assert resulting business state, not just clickability.
- Use unique subjects/test data and clean up created messages.
- Keep tests independent; avoid depending on execution order.
- Capture screenshots and current URL on failure.

## Required completion work
1. Inspect Proton Mail and verify selectors in all page objects.
2. Replace placeholder assertions with observable UI-state assertions.
3. Complete sender/receiver delivery verification using two controlled accounts.
4. Complete draft persistence, inbox state transitions, filters, Undo Send and attachment download checks.
5. Add a deterministic test-data setup/cleanup approach.
6. Execute the suite and record actual pass/fail/blocked outcomes. Never mark unexecuted tests as passed.
7. Fill defect report only with reproducible findings.
8. Record browser/version/OS and add a 4–5 minute walkthrough.

## Assessment quality review – suggested answers
1. **Not automated:** CAPTCHA, real security challenge flows, visual/usability judgment and highly destructive production actions. These need controlled environments or human review.
2. **Every PR:** valid login/session smoke, send/delivery smoke, draft save/reopen, keyword search, core inbox action. **Nightly:** advanced search, filters, attachment round-trip, Undo Send, broader browser matrix and negative/boundary cases.
3. **Local pass / CI intermittent:** compare browser/driver versions, viewport, timing, network, test data and environment; inspect screenshots/logs; reproduce headlessly; isolate shared state; fix synchronization or test-data race.
4. **Frequent UI changes:** prefer stable accessible roles/labels and test IDs agreed with developers; centralize locators; avoid brittle absolute XPath; keep component objects small.
5. **Scale to 200+:** domain-based page/component objects, fixtures, data factories, tags, parallel-safe accounts, API-assisted setup only where permitted, CI sharding, reporting and ownership.

