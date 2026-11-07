package com.qa.listeners;
import com.qa.driver.DriverFactory;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.ITestListener;
import java.io.File;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
 @Override public void onTestFailure(ITestResult result) {
  try {
   WebDriver d=DriverFactory.getDriver();
   File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
   Path dir=Path.of("target","screenshots"); Files.createDirectories(dir);
   String name=result.getMethod().getMethodName()+"_"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))+".png";
   Files.copy(src.toPath(),dir.resolve(name),StandardCopyOption.REPLACE_EXISTING);
   System.err.println("Failure screenshot: "+dir.resolve(name).toAbsolutePath());
   System.err.println("Failure URL: "+d.getCurrentUrl());
  } catch(Exception e){System.err.println("Could not capture failure evidence: "+e.getMessage());}
 }
}
