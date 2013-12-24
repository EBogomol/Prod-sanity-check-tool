package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class VideoListCreationPage extends EntityCreationPage{
    public static String videoListID;
    private WebElement videoUpload;
    private WebElement videoExternal;
    private WebElement target;


    public void createVideoListEntity(String videoExternalID){
        fillTitleField("VideoListTEst_SC");
        videoExternal = driver.findElement(By.id("picker_id_pickerId0_" + videoExternalID));
        target = driver.findElement(By.xpath(".//*[@id='pickerId0']/div/div[2]/div[1]/div/div/ul/li[1]"));
        new Actions(driver).dragAndDrop(videoExternal, target).perform();
        clickSubmitButton();
        String videoListURL = driver.getCurrentUrl();
        videoListID = getEntityID(videoListURL);
    }
    public boolean checkAbilityToCreateVideoListEntity(){
        settingModule = driver.findElement(By.className("accordion-inner"));

        if (settingModule.isDisplayed())
            return true;
        else return false;
    }
}
