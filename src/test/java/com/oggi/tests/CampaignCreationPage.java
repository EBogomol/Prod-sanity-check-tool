package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CampaignCreationPage extends EntityCreationPage {
    private WebElement campaignName;
    private WebElement industryVerticalField;
    private WebElement campaignTypeField;
    private WebElement demoCheckBox;
    private WebElement playlistAreaHolder;
    private WebElement playlistEntity;

    BasePage basePage = new BasePage();

    public void createCampaignEntity(String playlistID) {
        campaignName = driver.findElement(By.id("EntityName"));
        campaignName.sendKeys("TestCampaign_SC_RPS");
        campaignTypeField = driver.findElement(By.id("CampaignType"));
        List<WebElement> typeOptions = campaignTypeField.findElements(By.tagName("option"));
        for (WebElement option : typeOptions) {
            if ("Rich Media".equals(option.getTagName())) ;
            option.click();
        }
        industryVerticalField = driver.findElement(By.id("Sector"));
        List<WebElement> verticalOptions = industryVerticalField.findElements(By.tagName("option"));
        for (WebElement option : verticalOptions) {
            if ("Automotive".equals(option.getTagName())) ;
            option.click();
        }
        demoCheckBox = driver.findElement(By.id("IsDemo"));
        demoCheckBox.click();
        clickSubmitButton();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        playlistEntity = driver.findElement(By.id("picker_id_pickerId_" + playlistID));
        playlistAreaHolder = driver.findElement(By.xpath(".//*[@id='pickerId']/div/div[2]/div[1]/div/div/ul/li"));
        new Actions(driver).dragAndDrop(playlistEntity, playlistAreaHolder).perform();
        clickSubmitButton();
    }

    public boolean checkAbilityToCreateCampaign() {
        playlistAreaHolder = driver.findElement(By.id("generalData"));
        if (playlistAreaHolder.isDisplayed())
            return true;
        else return false;
    }

}
