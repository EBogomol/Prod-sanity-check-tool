package com.oggi.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
   // @Test
    public void checkAbilityToMakeCampaignLife() {
        loginPage.loginToSystem(Login, Password);
        openDetailsPage(CampaignCreationPage.campaignId);
        WebElement insertionOrderEditBtn = driver.findElement(By.xpath(".//*[@id='col2']/div[1]/div[1]/div/div/a/i"));
        insertionOrderEditBtn.click();
        campaignCreationPage.uploadInsertionOrder();
        campaignCreationPage.launchCampaign();
        Assert.assertTrue(campaignCreationPage.checkAbilityToMakeCampaignIsLife(),"Campaign can't be life");
    }
    @Test
    public void exportTrackersIsPerformed() throws Exception {
        loginPage.loginToSystem(Login, Password);
        driver.get("http://manager.rm.collective.com/main/Campaign/Export/" + CampaignCreationPage.campaignId);
        Assert.assertTrue(basePage.checkFileExists(),"File wasn't loaded");
    }
}



