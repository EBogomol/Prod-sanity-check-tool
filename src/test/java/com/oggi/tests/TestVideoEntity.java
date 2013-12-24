package com.oggi.tests;


import org.testng.Assert;
import org.testng.annotations.Test;


public class TestVideoEntity extends EntityCreationPage {

    BasePage basePage = new BasePage();
    VideoCreationPage videoCreationPage = new VideoCreationPage();
    LoginPage loginPage = new LoginPage();


    public void uploadVideoEntityIsCreated() throws InterruptedException {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("Video");
        videoCreationPage.createUploadVideoEntity();
        Assert.assertTrue(videoCreationPage.checkAbilityToCreateVideoEntity(), "Upload Video entity can't be created");
    }

    @Test
    public void externalVideoIsCreated() {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("Video");
        videoCreationPage.createExternalVideoEntity();
        Assert.assertTrue(videoCreationPage.checkAbilityToCreateVideoEntity(), "External Video entity can't be created");
    }


}