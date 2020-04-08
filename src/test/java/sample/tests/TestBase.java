package sample.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;
import sample.appmanager.ApplicationManager;

public class TestBase {

  ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

  @Before
  public void setUp() {
    app.init();
  }

  @After
  public void tearDown() {
    app.stop();
  }
}