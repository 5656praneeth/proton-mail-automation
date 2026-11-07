package com.qa.pages;
import org.openqa.selenium.By;
public class DraftsPage extends BasePage {
 private final By drafts = By.xpath("//*[contains(.,'Drafts')]");
 public void openDrafts(){click(drafts);}
}
