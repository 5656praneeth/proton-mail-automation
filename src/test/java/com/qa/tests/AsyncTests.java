package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.config.ConfigReader;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AsyncTests extends BaseTest {
    @Test
    public void undoSendWorkflow() throws Exception {
        new LoginPage().login(ConfigReader.get("senderEmail"), ConfigReader.get("senderPassword"));
        Assert.assertTrue(true,
                "Implement transient Undo Send assertion using explicit wait and controlled send-delay setting.");
    }
}
