package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class WidgetCreationPage extends EntityCreationPage {
    static String widgetID;
    public WebElement widthField;
    private String widgetTitle;

    BasePage basePage = new BasePage();


    public void createWidget() {

        fillTitleField("TestWidgetEntity");
        WebElement select = driver.findElement(By.name("BaseEntity"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if ("f7e27ea9-4fb1-48d5-86c2-035a25429367".equals(option.getAttribute("value")))
                option.click();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickSubmitButton();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String widgetURL = driver.getCurrentUrl();
        widgetID = getEntityID(widgetURL);

    }

    public boolean checkAbilityToCreateWidget() {

        settingModule = driver.findElement(By.id("properties"));
        if (settingModule.isDisplayed())
            return true;
        else return false;

    }

    public void changeWidthField(int width) {
        driver.findElement(By.xpath(".//*[@id='content']/ul/li[2]/a")).click();
        String widthValue = String.valueOf(width);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        widthField = driver.findElement(By.id("Width"));
        widthField.clear();
        widthField.sendKeys(widthValue);
    }

    public void changeHeightField(int height) {
        String heightValue = String.valueOf(height);
        widthField = driver.findElement(By.id("Height"));
        widthField.clear();
        widthField.sendKeys(heightValue);
    }

    public boolean checkAbilityToEditWidget() {
        WebElement widthHeightElements = driver.findElement(By.xpath(".//*[@id='mainParameters']/div/div/div[2]/div[2]"));
        String widthHeightValues = widthHeightElements.getText();
        try {
            widgetTitle = basePage.getTitle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (widgetTitle.equals("TestWidget_SC_RPS Widget") && widthHeightValues.equals("300 / 300"))
            return true;
        else return false;

    }
}