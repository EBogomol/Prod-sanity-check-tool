package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("Properties_0__Name"));

        clickSubmitButton();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("widgetObject"));

        String widgetURL = driver.getCurrentUrl();
        widgetID = getEntityID(widgetURL);

    }

    public boolean checkAbilityToCreateWidget() {

        settingModule = driver.findElement(By.id("properties"));
        return settingModule.isDisplayed();


    }

    public void changeWidthField(int width) {
        driver.findElement(By.xpath(".//*[@id='content']/ul/li[2]/a")).click();
        String widthValue = String.valueOf(width);

        final Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withMessage("Schema tab not found")
                .withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value='Schema']")));


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
        return widgetTitle.equals("TestWidget_SC_RPS Widget") && widthHeightValues.equals("300 / 300");
    }
}