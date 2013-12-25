package com.oggi.tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CloneEntityPage extends EntityCreationPage {
    private WebElement replaceWithField;
    private WebElement entitiesTree;
    private WebElement appendCheckBox;


    public void cloneEntity(){
        appendCheckBox = driver.findElement(By.xpath(".//*[@id='body']/div/form/div[1]/div[2]/fieldset/div[3]/label"));
        appendCheckBox.click();
        replaceWithField = driver.findElement(By.id("RenameParameters_StringToReplace"));
        replaceWithField.sendKeys("check_clone");
        entitiesTree = driver.findElement(By.xpath("//div[@class='well clone-child-items']"));
        List <WebElement> entities = entitiesTree.findElements(By.xpath("//label[@class='checkbox']"));
                for(WebElement entity:entities){
                       entity.click();
                }
        clickSubmitButton();
    }
    public boolean checkAbilityToCloneEntities(){
        driver.get("http://manager.rm.collective.com/main/Search?searchCriteria=&entityDef=All");
        search("check_clone");
        String totalFoundStr = driver.findElement(By.xpath(".//*[@id='body']/div/div[1]/div[1]")).getText();
        if (totalFoundStr.equals("Total found: 7"))
            return true;
        else return false;
    }
}
