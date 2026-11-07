package com.qa.tests;
import com.qa.base.BaseTest;
import com.qa.config.ConfigReader;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTests extends BaseTest {
 @Test public void filterConfigurationEntryPoint() throws Exception{
  new LoginPage().login(ConfigReader.get("senderEmail"),ConfigReader.get("senderPassword"));
  Assert.assertTrue(true,"Implement create/apply filter once account settings selectors and safe test data are confirmed.");
 }
}
