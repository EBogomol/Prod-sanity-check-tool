package com.oggi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVideoList extends EntityCreationPage {

    BasePage basePage = new BasePage();
    VideoListCreationPage videoListCreationPage = new VideoListCreationPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void AdListIsCreated() {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("VideoList");
        videoListCreationPage.createVideoListEntity(VideoCreationPage.externalVideoEntityID);
        Assert.assertTrue(videoListCreationPage.checkAbilityToCreateVideoListEntity(), "VideoList entity can't be created");
    }
}

