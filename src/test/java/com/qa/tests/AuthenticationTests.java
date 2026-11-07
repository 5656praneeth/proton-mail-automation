package com.qa.tests;
import com.qa.base.BaseTest;
import com.qa.config.ConfigReader;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTests extends BaseTest {
 @Test(priority=0, description="Valid user can authenticate")
 public void validLogin() throws Exception {
  LoginPage page=new LoginPage();
  page.login(ConfigReader.get("senderEmail"),ConfigReader.get("senderPassword"));
  Assert.assertTrue(page.isAuthenticated(),"Expected authenticated mailbox URL; verify URL assertion for current Proton UI.");
 }
 @Test(priority=1, description="Invalid credentials show validation")
 public void invalidLogin() throws Exception {
  LoginPage page=new LoginPage();
  page.login("invalid-user@example.com","wrong-password");
  Assert.assertTrue(page.isLoginErrorVisible(),"Expected a visible authentication error; verify locator.");
 }
}
