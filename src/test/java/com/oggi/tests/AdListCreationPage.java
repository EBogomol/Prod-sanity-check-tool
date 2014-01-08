package com.oggi.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdListCreationPage extends EntityCreationPage {
    public static String adlistID;
    private WebElement adUpload;
    private WebElement adExternal;
    private WebElement adXML;
    private WebElement adSWF;
    private WebElement targetArea;
    private WebElement deleteAdButton;


    BasePage basePage = new BasePage();

    public void createAdListEntity(String UploadAdId, String ExternalAdId, String XMLAdId, String SWFAdId) {
        fillTitleField("TestAdListEntity_RPS");
        adUpload = driver.findElement(By.id("picker_id_pickerId_" + UploadAdId));
        targetArea = driver.findElement(By.xpath(".//*[@id='pickerId']/div/div[2]/div[1]/div/div/ul"));
        new Actions(driver).dragAndDrop(adUpload, targetArea).perform();
        adExternal = driver.findElement(By.id("picker_id_pickerId_" + ExternalAdId));
        new Actions(driver).dragAndDrop(adExternal, targetArea).perform();
        adXML = driver.findElement(By.id("picker_id_pickerId_" + XMLAdId));
        new Actions(driver).dragAndDrop(adXML, targetArea).perform();
        adSWF = driver.findElement(By.id("picker_id_pickerId_" + SWFAdId));
        new Actions(driver).dragAndDrop(adSWF, targetArea).perform();
        clickSubmitButton();
        String adListURL = driver.getCurrentUrl();
        adlistID = getEntityID(adListURL);

    }

    public void editAdListEntity() {
        deleteAdButton = driver.findElement(By.xpath(".//*[@id='pickerId']/div/div[2]/div[1]/div/div/ul/li[4]/i"));
        deleteAdButton.click();
        clickSubmitButton();
    }

    public boolean checkAbilityToCreateAdListEntity() {
        settingModule = driver.findElement(By.id("ads"));
        return settingModule.isDisplayed();
    }

    public boolean checkAbilityToEditAdList() {

        int row = driver.findElements(By.xpath(".//*[@id='ads']/div/table/tbody/tr")).size();
        if (row == 3)
            return true;
        else return false;
    }


}
