package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BulkRenamePage extends EntityCreationPage {
    private WebElement findField;
    private WebElement findBtn;
    private WebElement replaceField;
    private WebElement replaceButton;
    private String foundEntitiesRes;
    private WebElement allCheckBox;
    private WebElement saveBtn;

    BasePage basePage = new BasePage();

    public void performBulkRename() {
        findField = driver.findElement(By.id("Find"));
        findField.sendKeys("RPS");
        findBtn = driver.findElement(By.id("btnFind"));
        findBtn.click();
        replaceField = driver.findElement(By.id("Replace"));
        replaceField.sendKeys("bulkRename");
        allCheckBox = driver.findElement(By.id("All"));
        allCheckBox.click();
        replaceButton = driver.findElement(By.xpath(".//*[@id='bulkRename']/form[2]/div[1]/div/div/input[1]"));
        replaceButton.click();
        saveBtn = driver.findElement(By.xpath(".//*[@id='bulkRename']/form[2]/div[3]/button"));
        saveBtn.click();
    }

    public boolean checkBulkRenameFuntion() {
        foundEntitiesRes = driver.findElement(By.xpath(".//*[@id='body']/div/div[2]/h2")).getText();
        if (foundEntitiesRes.equals("1 entity successfully renamed"))
            driver.get("http://manager.rm.collective.com/main/Search?searchCriteria=&entityDef=All");
        else
            System.out.println("Something goes wrong during bulk renaming");

        basePage.search("bulkRename");
        String totalFoundStr = driver.findElement(By.xpath(".//*[@id='body']/div/div[1]/div[1]")).getText();
        if (totalFoundStr.equals("Total found: 1"))
            return true;
        else return false;

    }
}
