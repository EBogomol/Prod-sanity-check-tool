package com.oggi.tests;

import org.testng.annotations.Test;

public class TestClone extends EntityCreationPage {
    BasePage basePage = new BasePage();
    CloneEntityPage cloneEntityPage = new CloneEntityPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void checkAbilityToCloneEntity() {
        loginPage.loginToSystem(Login, Password);
        driver.get("http://manager.rm.collective.com/main/Playlist/f8d888ba-f700-4786-b0a2-73efaa43878b");
        basePage.cloneEntity();
        cloneEntityPage.cloneEntity();
    }
}
