package com.oggi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SchemaEntityCreationPage extends EntityCreationPage {
    private WebElement buttonCount;
    private WebElement addButtonsButton;
    private WebElement clearButton;
    public static String schemaEntityID;
    BasePage basePage = new BasePage();

    public void createSchemaEntity(){
        fillTitleField("Schema_entity_test_SC_RPS");
        clickSubmitButton();
        String schemaEntityURL = driver.getCurrentUrl();
        schemaEntityID = getEntityID(schemaEntityURL);
    }
    public void addButtonsToSchema(int buttonsCount){
        buttonCount = driver.findElement(By.id("buttonCount"));
        String countOfButtons = String.valueOf(buttonsCount);
        buttonCount.sendKeys(countOfButtons);
        addButtonsButton = driver.findElement(By.xpath(".//*[@id='buttonCountForm']/div/button"));
        addButtonsButton.click();


    }
    public void clearSchemaElements(){
        clearButton = driver.findElement(By.xpath(".//*[@id='body']/div/div[2]/div[1]/div[2]/button[2]"));
        clearButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        driver.findElement(By.xpath("html/body/div[2]/div[2]/a[2]")).click();
    }

    public void fillSchemaElement(){
        WebElement elementName = driver.findElement(By.xpath(".//*[@id='nameAndElements']/fieldset[2]/table/tbody/tr[1]/td[1]/input"));
        elementName.sendKeys("testButtonAction");
    }
    public boolean checkAbilityToEditSchemaEntity(){
        settingModule = driver.findElement(By.id("properties"));
        String schemaTitle = basePage.getTitle();
        if ((settingModule.isDisplayed())&&(schemaTitle.equals("TestEditSchema_RPS_SC Schema")))
            return true;
        else return false;
    }
    public boolean checkAbilityToCreateSchemaEntity(){
        settingModule = driver.findElement(By.id("properties"));
        String schemaTitle = basePage.getTitle();
        if ((settingModule.isDisplayed())&&(schemaTitle.equals("Schema_entity_test_SC_RPS Schema")))
            return true;
        else return false;
    }

}
