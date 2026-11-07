package com.qa.pages;

import com.qa.utils.ElementActions;
import org.openqa.selenium.By;

public abstract class BasePage {
    protected void click(By by) {
        ElementActions.click(by);
    }

    protected void type(By by, String value) {
        ElementActions.type(by, value);
    }

    protected String text(By by) {
        return ElementActions.text(by);
    }

    protected boolean displayed(By by) {
        return ElementActions.displayed(by);
    }

    protected void switchToFrame(String frameId) {
        ElementActions.switchToFrame(frameId);
    }

    protected void switchToFrame(By by) {
        ElementActions.switchToFrame(by);
    }
}
