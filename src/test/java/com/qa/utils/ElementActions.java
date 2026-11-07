package com.qa.utils;

import com.qa.driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public final class ElementActions {
    private ElementActions() {
    }

    public static void click(By by) {
        WaitUtils.clickable(by).click();
    }

    public static void type(By by, String value) {
        WebElement e = WaitUtils.visible(by);
        e.clear();
        e.sendKeys(value);
    }

    public static String text(By by) {
        return WaitUtils.visible(by).getText().trim();
    }

    public static boolean displayed(By by) {
        try {
            return DriverFactory.getDriver().findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void upload(By by, String absolutePath) {
        WaitUtils.visible(by).sendKeys(absolutePath);
    }

    public static void selectByText(By by, String value) {
        new Select(WaitUtils.visible(by)).selectByVisibleText(value);
    }

    public static void switchToFrame(String frameId) {
        DriverFactory.getDriver().switchTo().frame(frameId);
    }

    public static void switchToFrame(By by) {
        DriverFactory.getDriver().switchTo().frame(WaitUtils.visible(by));
    }
}
