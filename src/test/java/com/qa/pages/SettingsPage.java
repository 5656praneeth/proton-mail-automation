package com.qa.pages;
import org.openqa.selenium.By;
public class SettingsPage extends BasePage {
 // Add verified selectors for filters/rules after exploring the target account.
 private final By settings = By.xpath("//*[contains(.,'Settings')]");
 public void openSettings(){click(settings);}
}
