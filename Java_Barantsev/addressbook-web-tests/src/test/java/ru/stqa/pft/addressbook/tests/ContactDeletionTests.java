package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactModificationTests () {
    app.getContactHelper().initContactModification();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().returnToHomePage();
  }
}
