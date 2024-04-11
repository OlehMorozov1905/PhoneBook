package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isHomeComponentPresent()) {
            app.getHomePage().clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponentPresentTest() {
//        System.out.println("Home components is " + isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());
    }

    public boolean isHomeComponentPresent() {
        return app.getHomePage().isElementPresent(By.cssSelector("div:nth-child(2) div h1"));
    }
}
