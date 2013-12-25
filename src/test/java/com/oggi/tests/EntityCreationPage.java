package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EntityCreationPage extends BasePage {

    public WebElement SubmitButton;
    public WebElement CancelButton;
    public WebElement externalButton;
    public WebElement selectButton;
    public WebElement titleField;
    public WebElement customName;
    public WebElement customValue;
    public WebElement addButton;
    public WebElement descriptioField;
    public WebElement deletecustomAtrButton;


    public void clickSubmitButton() {
        SubmitButton = driver.findElement(By.id("btnSubmit"));
        SubmitButton.click();
    }

    public void clickCancelButton() {
        CancelButton = driver.findElement(By.linkText("Cancel"));
        CancelButton.click();
    }

    public void uploadFile(String path) {
        WebElement UploadButton = driver.findElement(By.id("MediaFile_fUpload"));
        UploadButton.sendKeys(path);
    }

    public void fillTitleField(String entityTitle) {
        titleField = driver.findElement(By.id("EntityName"));
        titleField.sendKeys(entityTitle);
    }

    public void selectEntity(String titleOfEntity) {
        selectButton = driver.findElement(By.className("bla"));
    }

    public String getEntityID(String URL) {
        String[] params = URL.split("/");
        if (params.length >= 5) {
            return params[5];
        }
        return "";
    }
    public void openEditPage(String entityID, String entityName) {

        driver.get("http://manager.rm.collective.com/main/" + entityName + "/Edit/" + entityID);
    }

    public void changeTitle(String newName) {
        titleField = driver.findElement(By.id("EntityName"));
        titleField.clear();
        titleField.sendKeys(newName);
    }

    public void fillCustomAttribute() {
        customName = driver.findElement(By.className("attr-name"));
        customName.sendKeys("TestCustomAttr");
        customValue = driver.findElement(By.xpath(".//*[@id='dvCustomAttrs']/div/input[2]"));
        customValue.sendKeys("TestValue");
    }
    public void addCustomAttribute(){
        addButton = driver.findElement(By.className("icon-plus"));
        addButton.click();
    }
    public void removeCustomAttribute(){
        deletecustomAtrButton = driver.findElement(By.xpath(".//*[@id='dvCustomAttrs']/div[2]/a[2]/i"));
        deletecustomAtrButton.click();
    }
    public void fillDiscriptionfield(String descriptionValue){
        descriptioField = driver.findElement(By.id("Description"));
        descriptioField.sendKeys(descriptionValue);
    }


}
