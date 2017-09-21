package com.com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AppiumTest {
    WebDriver driver;
    
  @Test
  public void f() {
      System.out.println("::::::::::::Test Scrip Has Started::::::::");
      driver.findElements(By.xpath("//android.widget.ImageButton")).get(0).click();
      driver.findElement(By.id("com.android.calculator2:id/digit8")).click();
      driver.findElement(By.id("com.android.calculator2:id/plus")).click();
      driver.findElement(By.id("com.android.calculator2:id/digit5")).click();
      driver.findElement(By.id("com.android.calculator2:id/equal")).click();
      System.out.println(":::::::finally Success::::::::::");
  }
  
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
      System.out.println("Before");
   // Created object of DesiredCapabilities class.
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("deviceName", "CP8298I000x076b8c04");
      capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
      capabilities.setCapability(CapabilityType.VERSION, "5.1");
      capabilities.setCapability("platformName", "Android");
      capabilities.setCapability("appPackage", "com.android.calculator2");
      capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

      // Created object of RemoteWebDriver will all set capabilities.
      // Set appium server address and port number in URL string.
      // It will launch calculator app in android device.
      driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      
      System.out.println("driver is initialized");
  }

  @AfterMethod
  public void afterMethod() {
      System.out.println("After");
  }

}
