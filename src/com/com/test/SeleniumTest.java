package com.com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @pawan
 */
public class SeleniumTest {
    static WebDriver driver = null;
    public static void main(String[] args) throws InterruptedException {
	driverInitializer("chrome"/*args[0]*/, "D:\\IBaseDev\\testifyapp\\Drivers"/*args[1]*/);
	scriptWriter();
    }

    private static void scriptWriter() throws InterruptedException {
	driver.get("https://www.google.com");
	System.out.println(driver.getCurrentUrl());
	Thread.sleep(2000);
	driver.close();
    }

    private static void driverInitializer(String browser, String driverPath) {
	DesiredCapabilities caps = null;
	if ("ff".equalsIgnoreCase(browser))
	    forFireFox(driverPath, caps);
	else if ("chrome".equalsIgnoreCase(browser))
	    forChrome(driverPath, caps);
	else if ("IE".equalsIgnoreCase(browser))
	    forIE(driverPath, caps);
	else if ("safari".equalsIgnoreCase(browser))
	    forSafari(driverPath, caps);
    }

    private static void forSafari(String driverPath, DesiredCapabilities caps) {
	driver = new SafariDriver();
    }

    private static void forIE(String driverPath, DesiredCapabilities caps) {
	System.setProperty("webdriver.ie.driver", driverPath+"\\IEDriverServer.exe");
	caps = DesiredCapabilities.internetExplorer();
	caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
	caps.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
	caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
	caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
	driver = new InternetExplorerDriver(caps);
    }

    private static void forChrome(String driverPath, DesiredCapabilities caps) {
	System.setProperty("webdriver.chrome.driver", driverPath+"\\chromedriver.exe");
	caps = DesiredCapabilities.chrome();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("test-type");
	caps.setCapability("chrome.binary", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	caps.setCapability(ChromeOptions.CAPABILITY, options);
	driver = new ChromeDriver(caps);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void forFireFox(String driverPath, DesiredCapabilities caps) {
	driver = new FirefoxDriver();
    }

}
