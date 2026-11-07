package com.qa.pages;

import org.openqa.selenium.By;
import com.qa.utils.WaitUtils;

public class InboxPage extends BasePage {
    private final By compose = By.xpath("//button[@data-testid='sidebar:compose']");
    private final By messageRows = By.cssSelector("[data-testid='message-row']"); // VERIFY
    private final By searchBox = By.cssSelector("input[type='search']"); // VERIFY

    public void openCompose() {
        click(compose);
    }

    public int messageCount() {
        return com.qa.driver.DriverFactory.getDriver().findElements(messageRows).size();
    }

    public void search(String query) {
        type(searchBox, query);
        searchBoxEnter(searchBox);
    }

    private void searchBoxEnter(By by) {
        WaitUtils.visible(by).sendKeys(org.openqa.selenium.Keys.ENTER);
    }
}
