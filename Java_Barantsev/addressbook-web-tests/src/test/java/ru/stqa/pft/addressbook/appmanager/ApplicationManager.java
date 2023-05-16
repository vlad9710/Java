package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
  protected WebDriver driver;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String browser;
  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser == Browser.FIREFOX.browserName()) {
      driver = new FirefoxDriver();
    } else if (browser == Browser.CHROME.browserName()) {
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
      driver = new ChromeDriver(chromeOptions);
    } else if (browser == Browser.IE.browserName()) {
      driver = new InternetExplorerDriver();
    }

    baseUrl = "https://www.google.com/";
    driver.manage()
            .timeouts()
            .implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook");
    groupHelper = new GroupHelper(driver);
    contactHelper = new ContactHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }


  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo()
              .alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
