package sample.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  public String browser;
  public SessionHelper sessionHelper;
  public NavigationHelper navigationHelper;
  public GroupHelper groupHelper;
  public ContactHelper contactHelper;

  public WebDriver driver;

  public ApplicationManager(String browser){
    this.browser = browser;
  }

  public void init() {

    if (browser.equals(BrowserType.FIREFOX)){
      driver = new FirefoxDriver();
    }
    else if (browser.equals(BrowserType.CHROME)) {
      driver = new ChromeDriver();
    }
    else if (browser.equals(BrowserType.SAFARI)) {
      driver = new SafariDriver();
    }
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook/index.php");
    groupHelper = new GroupHelper(driver);
    contactHelper = new ContactHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    driver.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}