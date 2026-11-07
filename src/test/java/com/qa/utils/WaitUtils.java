package com.qa.utils;

import com.qa.config.ConfigReader;
import com.qa.driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public final class WaitUtils {
    private static WebDriverWait wait;

    private WaitUtils() {
    }

    private static WebDriverWait w() {
        if (wait == null)
            wait = new WebDriverWait(DriverFactory.getDriver(),
                    Duration.ofSeconds(ConfigReader.getInt("explicitWaitSeconds")));
        return wait;
    }

    public static WebElement visible(By by) {
        return w().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement clickable(By by) {
        return w().until(ExpectedConditions.elementToBeClickable(by));
    }

    public static boolean urlContains(String text) {
        return w().until(ExpectedConditions.urlContains(text));
    }

    public static boolean textPresent(By by, String text) {
        return w().until(d -> d.findElement(by).getText().contains(text));
    }

    public static void reset() {
        wait = null;
    }
}
