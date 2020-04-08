package sample.tests;

import org.junit.Test;
import sample.model.ContactData;

public class ContactCreationTest extends TestBase {
  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createContact(new ContactData("test_name", "test_surname", "test1"));
  }
}