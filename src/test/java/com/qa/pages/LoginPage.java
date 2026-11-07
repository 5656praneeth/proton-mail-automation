package com.qa.pages;

import org.openqa.selenium.By;
import com.qa.utils.WaitUtils;

/**
 * IMPORTANT: Proton may change markup or use iframe/shadow-root components.
 * Inspect the live DOM and replace the locator placeholders before running.
 */
public class LoginPage extends BasePage {
	private final By signInbasepage = By.xpath("//a[text()='Sign in']");
	private final By username = By.xpath("//input[@id='username' and @spellcheck='false']"); 
	private final By password = By.xpath("//input[@id='password' and @spellcheck='false']"); 
	private final By continue1 = By.xpath("//button[text()='Continue']"); 
	
	private final By signIn = By.xpath("//*[text()='Sign in']"); // VERIFY
	private final By error = By.xpath("//*[contains(text(),'This email address does not exist')]"); // VERIFY
     private final By compose = By.xpath("//button[@data-testid='sidebar:compose']");
	public void login(String user, String pass) throws Exception {
		click(signInbasepage);
		type(username, user);
		click(continue1);
		type(password, pass);
		click(signIn);

        WaitUtils.clickable(compose);
		
	}

	public boolean isLoginErrorVisible() {

		System.out.println("passed");
		return displayed(error);
		
	}

	public boolean isAuthenticated() {
	if(	WaitUtils.urlContains("/u/"))
			System.out.println("passed");
	        
		return WaitUtils.urlContains("/u/");
	} 
}
