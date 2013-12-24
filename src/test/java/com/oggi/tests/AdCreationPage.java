package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdCreationPage extends EntityCreationPage {
    private WebElement uploadButton;
    private WebElement adType;
    public static String adUploadEntityID;
    public static String adExternalEntitylD;
    public static String adXMLEntitylD;
    public static String adSWFEntitylD;

    public void createADUpload() {
        fillTitleField("testAdImageUploadSC");
        uploadFile("file:///C:/Users/ebogomol/Pictures/testPicute.jpg");
        clickSubmitButton();
        String adUploadEntityURL = driver.getCurrentUrl();
        adUploadEntityID = getEntityID(adUploadEntityURL);
    }

    public void createADExternal() {
        fillTitleField("testAdImageExternal_SC_RPS");
        uploadButton = driver.findElement(By.id("btnExternal"));
        uploadButton.click();
        externalButton = driver.findElement(By.id("MediaFile"));
        externalButton.sendKeys("http://cdn.oggifinogi.com/prod/2013-10/b87b0471-e628-4df6-aa34-344a39612f71_v1.jpg");
        clickSubmitButton();
        String adExternalEntityURl = driver.getCurrentUrl();
        adExternalEntitylD = getEntityID(adExternalEntityURl);
    }

    public void createXMLDocument() {
        fillTitleField("testXMLDocument_SC_RPS");
        adType = driver.findElement(By.id("Source"));
        adType.sendKeys("Document");
        uploadButton = driver.findElement(By.id("btnExternal"));
        uploadButton.click();
        externalButton = driver.findElement(By.id("MediaFile"));
        externalButton.sendKeys("http://cdn.rm.collective-media.net/prod/2013-08/22c675bf-60b0-4121-b27d-b3c75ede945d_v6.xml");
        clickSubmitButton();
        String adXMLEntityURl = driver.getCurrentUrl();
        adXMLEntitylD = getEntityID(adXMLEntityURl);
    }
    public void createSWF() {
        fillTitleField("testSWFSC_RPS");
        adType = driver.findElement(By.id("Source"));
        adType.sendKeys("Flash");
        uploadButton = driver.findElement(By.id("btnExternal"));
        uploadButton.click();
        externalButton = driver.findElement(By.id("MediaFile"));
        externalButton.sendKeys("http://cdn.rm.collective-media.net/prod/2012-12/287b3cc7-4458-4584-8c13-591a05286ccb_v1.swf");
        clickSubmitButton();
        String adSWFEntityURl = driver.getCurrentUrl();
        adSWFEntitylD = getEntityID(adSWFEntityURl);

    }

    public boolean checkAbilityToCreateAd() {

        settingModule = driver.findElement(By.id("properties"));

        if (settingModule.isDisplayed())
            return true;
        else return false;

    }

}
