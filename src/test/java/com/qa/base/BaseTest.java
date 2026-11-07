package com.qa.base;
import com.qa.config.ConfigReader;
import com.qa.driver.DriverFactory;
import com.qa.utils.WaitUtils;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

public class BaseTest {
 protected WebDriver driver;
 @BeforeMethod(alwaysRun=true)
 public void setUp() {
  WaitUtils.reset(); DriverFactory.initDriver(); driver=DriverFactory.getDriver();
  driver.get(ConfigReader.get("baseUrl"));
 }
 @AfterMethod(alwaysRun=true)
 public void tearDown() { DriverFactory.quitDriver(); WaitUtils.reset(); }
}
