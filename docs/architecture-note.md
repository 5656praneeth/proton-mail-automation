# Architecture Note

- **Test runner:** TestNG; suite defined in `testng.xml`.
- **Browser lifecycle:** `DriverFactory` creates and closes WebDriver per test.
- **Configuration:** `config.properties`, with JVM system properties/environment variables taking precedence.
- **Page abstraction:** Page classes own locators and user actions; tests own business assertions.
- **Synchronization:** Explicit waits in `WaitUtils`; implicit wait is disabled.
- **Evidence:** `TestListener` captures screenshots on test failures; Selenium logs current URL.
- **Scalability:** Add page/component objects, fixtures, test data builders and tagged suites; keep tests independent.
- **Security:** Do not commit credentials. Use environment variables or CI secret storage.
- **Limitations:** Proton UI selectors and workflows must be verified against the actual account and current DOM. Authentication may involve CAPTCHA/2FA; do not bypass security controls.
