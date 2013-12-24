package com.oggi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EditAdEntityPage extends EntityCreationPage {
    private String adTitle;

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    AdCreationPage adCreationPage = new AdCreationPage();


    public void editAdEntity() {
        uploadFile("file:///C:/Users/Public/Pictures/Sample%20Pictures/Love2.jpeg");
        changeTitle("TestEditAd_RPS_SC");
        addCustomAttribute();
        fillCustomAttribute();
        removeCustomAttribute();
        clickSubmitButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public boolean checkAbilityToEditAdEntity() {
        try {
            adTitle = basePage.getTitle();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (adTitle.equals("TestEditAd_RPS_SC Ad"))
            return true;
        else return false;

    }

}




