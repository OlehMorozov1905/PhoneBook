package com.phonebook.tests;

import com.phoneBook.data.UserData;
import com.phoneBook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void createNewAccountPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void createNewAccountWithExistedEmailNegativeTest() {
        //кликаем на Login link
        app.getUser().clickOnLoginLink();
        //вводим email и пароль
        app.getUser().fillLoginRegisterForm(new User().setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        //кликаем на кнопку зарегистрироваться
        app.getUser().clickOnRegistrationButton();
        //assert Alert is present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
