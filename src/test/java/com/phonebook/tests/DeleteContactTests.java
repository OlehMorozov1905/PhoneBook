package com.phonebook.tests;

import com.phoneBook.models.Contact;
import com.phoneBook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("pulp_fiction2024@gmail.com")
                .setPassword("Chelsea$1905"));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("Vincent")
                .setLastName("Vega")
                .setPhone("1234567890")
                .setEmail("pulp_fiction@gmail.com")
                .setAddress("Mannheim")
                .setDescription("Mafia"));
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void deleteContactPositiveTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().removeContact();
        app.getContact().pause(500);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }
}
