package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VideoCreationPage extends EntityCreationPage {
    private WebElement uploadButton;
    private WebElement inputField;
    private WebElement loadButton;
    public static String externalVideoEntityID;


    BasePage basePage = new BasePage();


    public void createExternalVideoEntity() {

        fillTitleField("testVideoExtEntity_RPS");
        this.uploadButton = driver.findElement(By.id("btnMediaExternal"));
        this.uploadButton.click();
        inputField = driver.findElement(By.id("Media_MediaFile"));
        inputField.sendKeys("http://cdn.oggifinogi.com/prod/2013-10/08207e61-ce21-47ea-bba1-2826fce70232_v1.mp4");
        clickSubmitButton();
        String videoEntityURL = driver.getCurrentUrl();
        externalVideoEntityID = getEntityID(videoEntityURL);
    }
    public void createUploadVideoEntity() throws InterruptedException {

        fillTitleField("testVideoEntity_RPS");
        //uploadButton = driver.findElement(By.id("btnMediaUpload"));
        //uploadButton.click();
        //loadButton = driver.findElement(By.id("Media_MediaFile_btUpload"));
        //loadButton.click();
        inputField = driver.findElement(By.id("SWFUpload_0"));
        inputField.click();
        //Forms.SendKeys.SendWait("C:/Users/ebogomol/Video/TestPreroll.mp4");
        //uploadFile("file:///C:/Users/ebogomol/Video/TestPreroll.mp4");
        Thread.sleep(3000);
        clickSubmitButton();
    }
    public boolean checkAbilityToCreateVideoEntity(){
        settingModule = driver.findElement(By.id("properties"));

        if (settingModule.isDisplayed())
            return true;
        else return false;
    }
}
