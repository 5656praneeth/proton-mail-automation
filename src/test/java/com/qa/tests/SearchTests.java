package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.config.ConfigReader;
import com.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {
    @Test
    public void keywordSearch() throws Exception {
        new LoginPage().login(ConfigReader.get("senderEmail"), ConfigReader.get("senderPassword"));
        new SearchPage().searchFor("QA");
        Assert.assertTrue(true, "Add assertion against actual filtered message results.");
    }

    @Test
    public void advancedSearch() throws Exception {
        new LoginPage().login(ConfigReader.get("senderEmail"), ConfigReader.get("senderPassword"));
        new SearchPage().searchFor("from:qa@example.com subject:release");
        Assert.assertTrue(true, "Confirm Proton advanced query syntax and assert result set.");
    }
}
