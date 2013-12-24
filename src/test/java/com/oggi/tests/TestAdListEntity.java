package com.oggi.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAdListEntity extends EntityCreationPage {

    BasePage basePage = new BasePage();
    AdListCreationPage adListCreationPage = new AdListCreationPage();
    AdCreationPage adCreationPage = new AdCreationPage();
    LoginPage loginPage = new LoginPage();

    @Test (priority = 2)
    public void AdListIsCreated() {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("AdList");
        adListCreationPage.createAdListEntity(AdCreationPage.adUploadEntityID, AdCreationPage.adExternalEntitylD, AdCreationPage.adXMLEntitylD, AdCreationPage.adSWFEntitylD);
        Assert.assertTrue(adListCreationPage.checkAbilityToCreateAdListEntity(), "AdList entity can't be created");
    }

    @Test (priority = 3)
    public void adListIsEdited(){
        loginPage.loginToSystem(Login, Password);
        openEditPage(AdListCreationPage.adlistID,"AdList");
        adListCreationPage.editAdListEntity();
        Assert.assertTrue(adListCreationPage.checkAbilityToEditAdList(),"AdList entity can't be edited");
    }
}
