package com.oggi.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestWidgetEntity extends EntityCreationPage {

    BasePage basePage = new BasePage();
    WidgetCreationPage widgetCreationPage = new WidgetCreationPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void widgetEntityIsCreated()  {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("Widget");
        widgetCreationPage.createWidget();
        Assert.assertTrue(widgetCreationPage.checkAbilityToCreateWidget(), "Widget entity can't be created");

    }
    @Test
    public void widgetEntityIsEdited(){
        loginPage.loginToSystem(Login, Password);
        openEditPage(WidgetCreationPage.widgetID,"Widget");
        changeTitle("TestWidget_SC_RPS");
        widgetCreationPage.changeWidthField(300);
        widgetCreationPage.changeHeightField(300);
        clickSubmitButton();
        Assert.assertTrue(widgetCreationPage.checkAbilityToEditWidget(),"Widget entity can't be edited");
    }
}


