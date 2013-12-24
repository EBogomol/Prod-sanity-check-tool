package com.oggi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestLoginPage extends StartPoint {


    @Test
    public void isLoginToSystem() throws InterruptedException {

        driver.get(LinkToPortal);
        LoginPage loginPage = new LoginPage();
        loginPage.loginToSystem(Login, Password);
        Assert.assertTrue(loginPage.checkAccessToPortal(), "User wasn't able to login to the system");
    }

    @Test
    public static void isLoginToSystemNT() throws InterruptedException {
        driver.get(LinkToPortal);
        LoginPage loginPage = new LoginPage();
        loginPage.loginToSystem("incorrect_Login", "incorrect_Password");
        Assert.assertFalse(loginPage.checkAccessToPortal());
    }
}
