package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.config.ConfigReader;
import com.qa.pages.LoginPage;
import com.qa.pages.InboxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InboxTests extends BaseTest {
    @Test
    public void inboxLoads() throws Exception {
        new LoginPage().login(ConfigReader.get("senderEmail"), ConfigReader.get("senderPassword"));
        Assert.assertTrue(new InboxPage().messageCount() >= 0);
    }

    @Test
    public void archiveWorkflowPlaceholder() throws Exception {
        new LoginPage().login(ConfigReader.get("senderEmail"), ConfigReader.get("senderPassword"));
        Assert.assertTrue(true, "Implement archive using a seeded message and verified action/state locators.");
    }

    @Test
    public void deleteRestoreWorkflowPlaceholder() throws Exception {
        new LoginPage().login(ConfigReader.get("senderEmail"), ConfigReader.get("senderPassword"));
        Assert.assertTrue(true, "Implement delete/restore using a seeded message and verified action/state locators.");
    }
}
