package com.qa.driver;
import com.qa.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.time.Duration;

public final class DriverFactory {
 private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
 private DriverFactory() {}
 public static void initDriver() {
  String browser = System.getProperty("browser", "chrome").toLowerCase();
  boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
  WebDriver driver;
  switch (browser) {
   case "firefox" -> { FirefoxOptions o = new FirefoxOptions(); if(headless)o.addArguments("-headless"); driver=new FirefoxDriver(o); }
   case "edge" -> { EdgeOptions o = new EdgeOptions(); if(headless)o.addArguments("--headless=new"); driver=new EdgeDriver(o); }
   default -> { ChromeOptions o = new ChromeOptions(); if(headless)o.addArguments("--headless=new"); o.addArguments("--disable-notifications"); driver=new ChromeDriver(o); }
  }
  driver.manage().timeouts().implicitlyWait(Duration.ZERO);
  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.getInt("pageLoadTimeoutSeconds")));
  driver.manage().window().maximize();
  DRIVER.set(driver);
 }
 public static WebDriver getDriver() {
  if (DRIVER.get()==null) throw new IllegalStateException("WebDriver is not initialized");
  return DRIVER.get();
 }
 public static void quitDriver() { if(DRIVER.get()!=null){DRIVER.get().quit();DRIVER.remove();} }
}
