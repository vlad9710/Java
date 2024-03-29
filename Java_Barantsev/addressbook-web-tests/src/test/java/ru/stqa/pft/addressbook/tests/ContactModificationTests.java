package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModificationTests() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("firstNameModify", "lastNameModify", "emailModify@mail.ru", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
