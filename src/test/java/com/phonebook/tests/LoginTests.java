package com.phonebook.tests;

import com.phoneBook.data.UserData;
import com.phoneBook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        //кликаем на Login link
        app.getUser().clickOnLoginLink();
        //вводим email и пароль
        app.getUser().fillLoginRegisterForm(new User().setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        //click on login button
        app.getUser().clickOnLoginButton();
        //assert Sign out button is present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }
    @Test
    public void loginNegativeTestWithoutEmail() {
        //кликаем на Login link
        app.getUser().clickOnLoginLink();
        //вводим email и пароль
        app.getUser().fillLoginRegisterForm(new User().setPassword(UserData.PASSWORD));
        //click on login button
        app.getUser().clickOnLoginButton();
        //assert Sign out button is present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
