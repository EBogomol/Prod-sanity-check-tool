package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseWidgetCreationPage extends EntityCreationPage {
    private WebElement width;
    private WebElement height;
    private WebElement schema;
    private WebElement schemaTab;
    private String bwURL;
    public static String bwID;
    private String bw_wid_URL;
    public static String bw_wid_ID;
    private WebElement descriptionField;
    private WebElement createWidgetcheckBox;


    BasePage basePage = new BasePage();

    public void createBaseWidgetEntityWithWidget() {
        fillTitleField("BaseWidget+Widget_entity_test_SC_RPS");
        this.width = driver.findElement(By.id("Width"));
        this.width.sendKeys("300");
        this.height = driver.findElement(By.id("Height"));
        this.height.sendKeys("400");
        uploadFile("file:///D:/Components%20testing/AnimationButton.swf");
        this.schema = driver.findElement(By.id("CommonSchema"));
        this.schema.sendKeys("Preroll Schema");
        clickSubmitButton();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickSubmitButton();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bw_wid_URL = driver.getCurrentUrl();
        bw_wid_ID =getEntityID(bw_wid_URL);
    }

    public void createBaseWidgetEntity() {
        fillTitleField("BaseWidget_entity_test_SC_RPS");
        this.width = driver.findElement(By.id("Width"));
        this.width.sendKeys("300");
        this.height = driver.findElement(By.id("Height"));
        this.height.sendKeys("400");
        uploadFile("file:///D:/Components%20testing/AnimationButton.swf");
        this.schema = driver.findElement(By.id("CommonSchema"));
        this.schema.sendKeys("Preroll Schema");
        createWidgetcheckBox = driver.findElement(By.id("CreateWidget"));
        createWidgetcheckBox.click();
        clickSubmitButton();
        bwURL = driver.getCurrentUrl();
        bwID = getEntityID(bwURL);
    }

    public void editBaseWidgetEntity() {
        fillDiscriptionfield("test_entity");
        clickSubmitButton();
    }

    public boolean checkAbilityToCreateBW() {
        settingModule = driver.findElement(By.id("properties"));
        if (settingModule.isDisplayed())
            return true;
        else return false;
    }

    public boolean checkAbilityToEditBW() {
        descriptionField = driver.findElement(By.xpath(".//*[@id='mainParameters']/div/div[1]/div[2]"));
        if (descriptionField.getText().equals("test_entity"))
            return true;
        else return false;
    }

}
