package sample;// Generated by Selenium IDE

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;


public class GroupCreationTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();

    login("admin", "secret");
  }

  private void login(String username, String password) {
    driver.get("http://localhost/addressbook/index.php");
    driver.manage().window().setSize(new Dimension(1680, 1050));
    driver.findElement(By.name("user")).sendKeys(username);
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.xpath("//form/input[3]")).click();
  }

  @Test
  public void groupCreation() {
    gotoGroupPage("groups");
    initGroupCreation("//form/input[4]");
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    returnToGroupPage("group page");
  }

  private void returnToGroupPage(String s) {
    driver.findElement(By.linkText(s)).click();
  }

  private void fillGroupForm(GroupData groupData) {
    driver.findElement(By.name("group_name")).click();
    driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
    driver.findElement(By.name("group_header")).click();
    driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    driver.findElement(By.name("group_footer")).click();
    driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    driver.findElement(By.name("submit")).click();
  }

  private void initGroupCreation(String s) {
    driver.findElement(By.xpath(s)).click();
  }

  private void gotoGroupPage(String groups) {
    driver.findElement(By.linkText(groups)).click();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}