package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public  class LoginPage extends StartPoint {

    WebElement LoginField;
    WebElement PasswordField;
    WebElement OkButton;



    public void loginToSystem(String login, String Password) {

        LoginField = driver.findElement(By.id("username"));
        LoginField.sendKeys(login);
        PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys(Password);
        OkButton = driver.findElement(By.id("submit"));
        OkButton.click();
        }

    public boolean checkAccessToPortal() {

        String SearchPageURL = driver.getCurrentUrl();
        if (SearchPageURL.equals("http://manager.rm.collective.com/main/Search?entityDef=All")) {
              return true;
        } else
              return false;

    }



}
