package com.oggi.tests;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import java.io.File;

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
    public void createUploadVideoEntity() throws ScriptException {

        fillTitleField("testVideoEntity_RPS");
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://manager.rm.collective.com/main/Video/Create");
        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("someFile", new FileBody(new File("file:///C:/Users/Public/Videos/Sample%20Videos/Wildlife.wmv")));
        httppost.setEntity(reqEntity);

        inputField = driver.findElement(By.id("Media_MediaFile"));
        inputField.sendKeys("file:///C:/Users/Public/Videos/Sample%20Videos/Wildlife.wmv");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickSubmitButton();
    }
    public boolean checkAbilityToCreateVideoEntity(){
        settingModule = driver.findElement(By.id("properties"));
        return settingModule.isDisplayed();

    }
}
