package com.oggi.tests;

import com.gargoylesoftware.htmlunit.javascript.host.Popup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class BasePage extends StartPoint {

    public WebElement deleteButtonOk;
    public static WebElement title;
    public static WebElement buttonClone;
    public String PageTitle;
    private WebElement deleteButton;
    private String afterDeleteUrl;
    public Popup SureWindow;


    public String getTitle() {
        try {
            title = driver.findElement(By.xpath(".//*[@id='body']/div/div[1]/h1"));
            PageTitle = title.getText();

            return PageTitle;
        } catch (Exception e) {
            return "Can't find page title";
        }

    }

    public void cloneEntity() {
        buttonClone = driver.findElement(By.xpath(".//*[@id='body']/div/div[3]/div/a[2]"));
        buttonClone.click();
    }

    public void openCreationPage(String entityName) {
        driver.get("http://manager.rm.collective.com/main/" + entityName + "/Create");
    }

    public boolean deleteUsedEntity(Map<String, String> entities) {
        boolean flag = false;
        for (Map.Entry<String, String> entry : entities.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            {

                driver.get("http://manager.rm.collective.com/main/" + value + "/" + key);
                deleteButton = driver.findElement(By.xpath(".//*[@id='body']/div/div[3]/button"));
                deleteButton.click();
                deleteButtonOk = driver.findElement(By.xpath("html/body/div[2]/div[2]/a[2]"));
                deleteButtonOk.click();
                WebElement failedToDeleteWin = driver.findElement(By.xpath("html/body/div[2]/div[1]"));
                if (failedToDeleteWin.isDisplayed())
                    flag = false;
                else flag = true;
            }
        }
        return flag;
    }

    public boolean deleteEntity(Map<String, String> entities) {
        boolean flag = false;
        for (Map.Entry<String, String> entry : entities.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            {

                driver.get("http://manager.rm.collective.com/main/" + value + "/" + key);
                deleteButton = driver.findElement(By.xpath(".//*[@id='body']/div/div[3]/button"));
                deleteButton.click();
                deleteButtonOk = driver.findElement(By.xpath("html/body/div[2]/div[2]/a[2]"));
                deleteButtonOk.click();
                afterDeleteUrl = driver.getCurrentUrl();
                if (afterDeleteUrl.equals("http://manager.rm.collective.com/main/Search"))
                    flag = false;
                else flag = true;
            }
        }
        return flag;
    }

    public boolean checkAbilityToDeleteEntity(Map<String, String> entities) {
        for (Map.Entry<String, String> entry : entities.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            driver.get("http://manager.rm.collective.com/main/" + value + "/" + key);
            WebElement errorMessageHeader = driver.findElement(By.xpath(".//*[@id='body']/div/div[1]/div[1]/h1"));
            String errorMessage = errorMessageHeader.getText();
            if (errorMessage.equals("Oops, some error occurred"))
                return true;
            else return false;
        }

        return false;

    }

}