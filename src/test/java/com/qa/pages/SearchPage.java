package com.qa.pages;

import org.openqa.selenium.By;

public class SearchPage extends BasePage {
    private final By search = By.cssSelector("input[type='search']"); // VERIFY

    public void searchFor(String query) {
        type(search, query);
        com.qa.utils.WaitUtils.visible(search).sendKeys(org.openqa.selenium.Keys.ENTER);
    }
}
