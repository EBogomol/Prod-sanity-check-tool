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
    private WebElement adServerField;
    private WebElement launchBtn;
    private WebElement statusField;
    public static String campaignId;

    BasePage basePage = new BasePage();

    public void createCampaignEntity(String playlistID) {
        campaignName = driver.findElement(By.id("EntityName"));
        campaignName.sendKeys("TestCampaign_SC_RPS");
        campaignTypeField = driver.findElement(By.id("CampaignType"));
        List<WebElement> typeOptions = campaignTypeField.findElements(By.tagName("option"));
        for (WebElement option : typeOptions) {
            if ("Rich Media".equals(option.getText())) ;
            option.click();
        }
        industryVerticalField = driver.findElement(By.id("Sector"));
        List<WebElement> verticalOptions = industryVerticalField.findElements(By.tagName("option"));
        for (WebElement option : verticalOptions) {
            if ("Automotive".equals(option.getText())) ;
            option.click();
        }
        demoCheckBox = driver.findElement(By.id("IsDemo"));
        demoCheckBox.click();
        adServerField = driver.findElement(By.id("AdServer"));
        List<WebElement> adServerOption = adServerField.findElements(By.tagName("option"));
        for (WebElement option : adServerOption)
            if ("Collective/Doubleclick/DBG/GN/Martha Stewart/Hearst/Horizon".equals(option.getText()))
                option.click();

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
        String campaignUrl = driver.getCurrentUrl();
        campaignId = getEntityID(campaignUrl);
    }

    public void uploadInsertionOrder() {
        WebElement uploadBtn = driver.findElement(By.id("ExcelIo_Name_fUpload"));
        uploadBtn.sendKeys(pathToInsertionOrder);
        clickSubmitButton();
    }
    public void launchCampaign(){
        launchBtn = driver.findElement(By.id("toggleLive"));
        launchBtn.click();
    }
    public void stopCampaign(){

    }

    public boolean checkAbilityToCreateCampaign() {
        playlistAreaHolder = driver.findElement(By.id("generalData"));
        if (playlistAreaHolder.isDisplayed())
            return true;
        else return false;
    }
    public boolean checkAbilityToMakeCampaignIsLife(){
        statusField = driver.findElement(By.xpath(".//*[@id='generalData']/div/div[6]/div[2]/span"));
        String statusValue = statusField.getText();
        System.out.println(statusValue);

        if(statusValue.equals("Live"))
            return true;
        else return false;
    }

}
