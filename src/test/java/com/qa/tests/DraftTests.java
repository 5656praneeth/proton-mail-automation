package com.qa.tests;
import com.qa.base.BaseTest;
import com.qa.config.ConfigReader;
import com.qa.pages.*;
import org.testng.annotations.Test;

public class DraftTests extends BaseTest {
 @Test(description="Create a draft")
 public void createDraft() throws Exception {
  new LoginPage().login(ConfigReader.get("senderEmail"),ConfigReader.get("senderPassword"));
  new InboxPage().openCompose();
  new ComposePage().compose(ConfigReader.get("receiverEmail"),"Draft "+System.currentTimeMillis(),"Draft body");
  // Draft auto-save timing/state must be verified with a stable saved indicator or draft-list assertion.
 }
 @Test(description="Open drafts area")
 public void openDrafts() throws Exception {
  new LoginPage().login(ConfigReader.get("senderEmail"),ConfigReader.get("senderPassword"));
  new DraftsPage().openDrafts();
 }
}
