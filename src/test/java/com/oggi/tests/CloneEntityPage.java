package com.oggi.tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CloneEntityPage extends EntityCreationPage {
    private WebElement replaceWithField;
    private WebElement entitiesTree;

    public void cloneEntity(){
        replaceWithField = driver.findElement(By.id("RenameParameters_StringToReplace"));
        replaceWithField.sendKeys("check_clone");
        entitiesTree = driver.findElement(By.xpath(".//*[@id='subItemsTree']/fieldset/div"));
        List <WebElement> entities =  entitiesTree.findElements(By.xpath(".//*[@id='subItemsTree']/fieldset/div/ul/li"));
                for(WebElement entity:entities){
                       entity.click();
                }
        clickSubmitButton();
    }
}
