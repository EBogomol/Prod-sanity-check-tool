package com.oggi.tests;

import com.gargoylesoftware.htmlunit.javascript.host.Popup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BasePage extends StartPoint {

    public WebElement deleteButtonOk;
    public static WebElement title;
    public static WebElement buttonClone;
    public String PageTitle;
    private WebElement deleteButton;
    private String afterDeleteUrl;
    public Popup SureWindow;
    private WebElement searchInputField;


    public String getTitle() {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
    public void openDetailsPage(String entityID){
        driver.get("http://manager.rm.collective.com/main/Campaign/"+entityID);
    }

    public boolean deleteUsedEntity(Map<String, String> entities) {
        boolean flag = false;
        for (Map.Entry<String, String> entry : entities.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            {

                driver.get("http://manager.rm.collective.com/main/" + value + "/" + key);
                deleteButton = driver.findElement(By.cssSelector("button[class='btn btn-danger']"));
                deleteButton.click();
                deleteButtonOk = driver.findElement(By.xpath("html/body/div[2]/div[2]/a[2]"));
                deleteButtonOk.click();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
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
                deleteButton = driver.findElement(By.cssSelector("button[class='btn btn-danger']"));
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
            return errorMessage.equals("Oops, some error occurred");
            }

        return false;

    }
    public void search(String searchTerm){
        searchInputField = driver.findElement(By.id("searchCombo_txtSearchCriteria"));
        searchInputField.sendKeys(searchTerm);
        WebElement searchBtn = driver.findElement(By.xpath(".//*[@id='header']/div/div/div[3]/div/div/form/button"));
        searchBtn.click();

    }
    public boolean checkExportTrackersFileExists() {
        File f = new File(pathToResourcesFolder + "\\EnsembleTrackers - TestCampaign_SC_RPS.xlsx");
         return f.exists();
}
    public void cleanDirectoryUp(){
        File file = new File(pathToResourcesFolder + "\\EnsembleTrackers - TestCampaign_SC_RPS.xlsx");
        if(file.delete()){
            System.out.println(file.getName() + " is deleted!");
        }else{
            System.out.println("Delete operation is failed.");
        }
    }
}
