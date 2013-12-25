package com.oggi.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClone extends EntityCreationPage {
    BasePage basePage = new BasePage();
    CloneEntityPage cloneEntityPage = new CloneEntityPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void checkAbilityToCloneEntity() {
        loginPage.loginToSystem(Login, Password);
        driver.get("http://manager.rm.collective.com/main/Playlist/" + PlayListEntityCreation.playListEntityID);
        basePage.cloneEntity();
        cloneEntityPage.cloneEntity();
        Assert.assertTrue(cloneEntityPage.checkAbilityToCloneEntities(), "Clone was performed unsuccessfully");
    }
}
