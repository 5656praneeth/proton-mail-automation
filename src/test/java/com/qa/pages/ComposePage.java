package com.qa.pages;

import com.qa.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ComposePage extends BasePage {
    private final By to = By.xpath("//input[@data-testid='composer:to']"); // VERIFY
    private final By subject = By.xpath("//input[@data-testid='composer:subject']"); // VERIFY
    private final By body = By.cssSelector("[contenteditable='true']"); // inside inbox frame
    private final By send = By.xpath("//button[contains(.,'Send')]");
    private final By attachment = By.xpath("//span[text()='Attachments']/..");

    public void compose(String recipient, String title, String message) {
        type(to, recipient);
        WaitUtilsEnter(to);
        type(subject, title);

      //  switchToFrame("inbox");
      //  type(body, message);
      //  DriverFactory.getDriver().switchTo().defaultContent();
    }

    private void WaitUtilsEnter(By by) {
        com.qa.utils.WaitUtils.visible(by).sendKeys(Keys.ENTER);
    }

    public void send() {
        click(send);
    }

    public void attach(String path) {
        com.qa.utils.ElementActions.upload(attachment, path);
    }

    public boolean isSendAvailable() {
        return displayed(send);
    }
}
