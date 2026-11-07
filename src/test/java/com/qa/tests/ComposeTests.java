package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.config.ConfigReader;
import com.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComposeTests extends BaseTest {
    @Test(description = "Compose and send an email")
    public void sendEmail() throws Exception {
        LoginPage login = new LoginPage();
        login.login(ConfigReader.get("senderEmail"), ConfigReader.get("senderPassword"));
        InboxPage inbox = new InboxPage();
        inbox.openCompose();
        ComposePage compose = new ComposePage();
        String subject = "QA Automation " + System.currentTimeMillis();
        compose.compose(ConfigReader.get("receiverEmail"), subject, "Automated test message");
        Assert.assertTrue(compose.isSendAvailable());
        compose.send();
    }

    @Test(description = "Compose validation - blank recipient")
    public void blankRecipientValidation() throws Exception {
        LoginPage login = new LoginPage();
        login.login(ConfigReader.get("senderEmail"), ConfigReader.get("senderPassword"));
        new InboxPage().openCompose();
        ComposePage compose = new ComposePage();
        compose.compose("", "Validation test", "Body");
        Assert.assertTrue(compose.isSendAvailable(),
                "Send control should be available for UI validation attempt; assert actual validation message after locator setup.");
    }

    @Test(description = "Invalid recipient validation")
    public void invalidRecipientValidation() throws Exception {
        LoginPage login = new LoginPage();
        login.login(ConfigReader.get("senderEmail"), ConfigReader.get("senderPassword"));
        new InboxPage().openCompose();
        ComposePage compose = new ComposePage();
        compose.compose("not-an-email", "Invalid recipient", "Body");
        Assert.assertTrue(compose.isSendAvailable(),
                "Replace with assertion for Proton's actual recipient validation behavior.");
    }
}
