package com.oggi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCampaignEntity extends EntityCreationPage {
    BasePage basePage = new BasePage();
    CampaignCreationPage campaignCreationPage = new CampaignCreationPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void campaignEntityIsCreated() {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("Campaign");
        campaignCreationPage.createCampaignEntity(PlayListEntityCreation.playListEntityID);
        Assert.assertTrue(campaignCreationPage.checkAbilityToCreateCampaign(), "Campaign entity can't be created");
    }
}



