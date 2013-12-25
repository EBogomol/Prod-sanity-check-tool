package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InvoiceGenerationPage extends EntityCreationPage {
    private WebElement menuList;
    private WebElement invoiceList;
    private WebElement createInvoice;
    private WebElement selectedCampaignsField;
    private WebElement previewButton;

    BasePage basePage = new BasePage();


    public void createInvoice() {
        menuList = driver.findElement(By.xpath(".//*[@id='body']/div/div[1]"));
        createInvoice = driver.findElement(By.xpath(".//*[@id='body']/div/div[1]/ul/li[2]/a"));
        createInvoice.click();
        selectedCampaignsField = driver.findElement(By.id("tbxCampaign"));
        selectedCampaignsField.sendKeys("Flash sanity check");
        previewButton = driver.findElement(By.xpath(".//*[@id='dvSelCampaigns']/div[1]/button"));
        previewButton.click();
        List<WebElement> mediaPartnerOptions = driver.findElements(By.id("ddlAdvertisers"));
        for (WebElement option : mediaPartnerOptions)
            if ("Oggifinogi".equals(option.getText()))
                option.click();
    }

}
