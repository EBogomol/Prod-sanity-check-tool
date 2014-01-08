package com.oggi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestAdEntity extends EntityCreationPage {

    BasePage basePage = new BasePage();
    AdCreationPage adCreationPage = new AdCreationPage();
    EditAdEntityPage editAdEntityPage = new EditAdEntityPage();
    LoginPage loginPage = new LoginPage();

    @Test (priority = 1)
    public void uploadAdIsCreated() {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("Ad");
        adCreationPage.createADUpload();
        Assert.assertTrue(adCreationPage.checkAbilityToCreateAd(), "Upload Ad can't be created");
    }

    @Test (priority = 1)
    public void externalAdIsCreated() {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("Ad");
        adCreationPage.createADExternal();
        Assert.assertTrue(adCreationPage.checkAbilityToCreateAd(), "External Ad can't be created");
    }

    @Test (priority = 1)
    public void documentIsCreated() {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("Ad");
        adCreationPage.createXMLDocument();
        Assert.assertTrue(adCreationPage.checkAbilityToCreateAd(), "Document Ad can't be created");
    }

   @Test (priority = 1)
    public void flashIsCreated() {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("Ad");
        adCreationPage.createSWF();
        Assert.assertTrue(adCreationPage.checkAbilityToCreateAd(), "Flash Ad can't be created");
    }
    @Test (priority = 2)
    public void adEntityIsEdited() {
        loginPage.loginToSystem(Login, Password);
        openEditPage(AdCreationPage.adUploadEntityID, "Ad");
        editAdEntityPage.editAdEntity();
        Assert.assertTrue(editAdEntityPage.checkAbilityToEditAdEntity(),"Ad Entity can't be edited");
    }
   // @Test
    public void alreadyExistedEntityCantBeCreated(){
        loginPage.loginToSystem(Login, Password);
        openCreationPage("Ad");
        adCreationPage.createXMLDocument();
    }

}



