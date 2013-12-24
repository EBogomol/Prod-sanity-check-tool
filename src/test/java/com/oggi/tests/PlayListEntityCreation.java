package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class PlayListEntityCreation extends EntityCreationPage {
    public WebElement AdType;
    public WebElement screen;
    public WebElement smallWidgetSelector;
    public WebElement smallWidgetEntity;
    private WebElement bigWidgetSelector;
    public WebElement bigWidgetEntity;
    public WebElement popupWindow;
    private WebElement imageField;
    private WebElement clickThroughURL;
    private WebElement videoListField;
    private WebElement finalFrameImage;
    private WebElement videoListEntity;
    private WebElement finalFrameImageEntity;
    private WebElement settingsTab;
    private WebElement centerExpandCheckbox;
    public static String playListEntityID;


    BasePage basePage = new BasePage();


    public void createPlayListEntity(String smallWidgetID) {

        fillTitleField("TestPlayListEntity_RPS");
        AdType = driver.findElement(By.id("UnitTypeId"));

        List<WebElement> optionsAdTypes = AdType.findElements(By.tagName("option"));
        for (WebElement option : optionsAdTypes) {
            if("Expand, Custom".equals(option.getText()))
                option.click();
        }
        screen = driver.findElement(By.id("Screen"));
        List<WebElement> optionsScreens = screen.findElements(By.tagName("option"));
        for (WebElement option : optionsScreens) {
            if("Desktop".equals(option.getText()))
                option.click();
        }
        smallWidgetSelector = driver.findElement(By.xpath(".//*[@id='WidgetId_dvInlinePicker']/button[1]"));
        smallWidgetSelector.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        //smallWidgetEntity = driver.findElement(By.id("picker_id_WidgetId_dvPickerDialog_" + smallWidgetID));
        smallWidgetEntity = driver.findElement(By.xpath(".//*[@id='WidgetId_dvPickerDialog']/div/div[4]/ul/li[1]"));
        smallWidgetEntity.click();
        bigWidgetSelector = driver.findElement(By.xpath(".//*[@id='BigWidgetId_dvInlinePicker']/button[1]"));
        bigWidgetSelector.click();
        bigWidgetEntity = driver.findElement(By.xpath(".//*[@id='BigWidgetId_dvPickerDialog']/div/div[4]/ul/li[3]"));
        bigWidgetEntity.click();
        addNSImage();
        clickSubmitButton();
        String playListEntityURL = driver.getCurrentUrl();
        playListEntityID = getEntityID(playListEntityURL);
    }

    public void addNSImage(){
        WebElement imageButton = driver.findElement(By.xpath(".//*[@id='Noscript_Image_dvInlinePicker']/button[1]"));
        imageButton.click();
        imageField = driver.findElement(By.xpath(".//*[@id='Noscript_Image_dvPickerDialog']/div/div[4]/ul/li[1]"));
        imageField.click();
        clickThroughURL = driver.findElement(By.id("Noscript_ClickThroughUrl"));
        clickThroughURL.sendKeys("http://google.com");
    }

    public void addVideoList(){
        videoListField = driver.findElement(By.xpath(".//*[@id='VideoListId_dvInlinePicker']/button[1]"));
        videoListField.click();
        videoListEntity = driver.findElement(By.xpath(".//*[@id='VideoListId_dvPickerDialog']/div/div[4]/ul/li[1]"));
        videoListEntity.click();
    }
    public void addFinalFrameImage(){
        finalFrameImage = driver.findElement(By.xpath(".//*[@id='FirstFrameImage_dvInlinePicker']/button[1]"));
        finalFrameImage.click();
        finalFrameImageEntity = driver.findElement(By.xpath(".//*[@id='FirstFrameImage_dvPickerDialog']/div/div[4]/ul/li[1]"));
        finalFrameImageEntity.click();
    }
    public void changePlayListSettings(){
        settingsTab = driver.findElement(By.xpath(".//*[@id='list-form']/div[2]/ul/li[2]/a"));
        settingsTab.click();
        centerExpandCheckbox = driver.findElement(By.id("rbCenterPosition"));
        centerExpandCheckbox.click();
        clickSubmitButton();
    }
    public boolean checkAbilityToCreatePlaylist() {

        settingModule = driver.findElement(By.id("properties"));
        if (settingModule.isDisplayed())
            return true;
        else return false;

    }
    public boolean checkAbilityToEditPlayList(){
        String position = driver.findElement(By.xpath(".//*[@id='mainParameters']/div/div/div[2]/div[1]/div[2]")).getText();
        if (position.equals("Center"))
            return true;
        else return false;
    }
}



