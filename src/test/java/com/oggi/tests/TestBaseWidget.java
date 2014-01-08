package com.oggi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

public class TestBaseWidget extends EntityCreationPage{

    BasePage basePage = new BasePage();
    BaseWidgetCreationPage baseWidgetCreationPage = new BaseWidgetCreationPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void baseWidgetEntity_WidgetIsCreated() {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("BaseWidget");
        baseWidgetCreationPage.createBaseWidgetEntityWithWidget(pathToSWf);
        Assert.assertTrue(baseWidgetCreationPage.checkAbilityToCreateBW(), "Base widget with Widget entity can't be created");
    }
    @Test
    public void baseWidgetEntityIsCreated(){
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("BaseWidget");
        baseWidgetCreationPage.createBaseWidgetEntity();
        Assert.assertTrue(baseWidgetCreationPage.checkAbilityToCreateBW(), "Base widget entity can't be created");
    }
    //@Test
    public void baseWidgetEntityIsEdited(){
        loginPage.loginToSystem(Login, Password);
        openEditPage(BaseWidgetCreationPage.bwID,"BaseWidget");
        baseWidgetCreationPage.editBaseWidgetEntity(pathToSWf);
        Assert.assertTrue(baseWidgetCreationPage.checkAbilityToEditBW(), "Base widget can't be edited");
    }
}
