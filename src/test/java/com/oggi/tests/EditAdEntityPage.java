package com.oggi.tests;

public class EditAdEntityPage extends EntityCreationPage {
    private String adTitle;

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    AdCreationPage adCreationPage = new AdCreationPage();


    public void editAdEntity() {
        uploadFile(pathToImageAd);
        changeTitle("TestEditAd_RPS_SC");
        addCustomAttribute();
        fillCustomAttribute();
        removeCustomAttribute();
        clickSubmitButton();
    }

    public boolean checkAbilityToEditAdEntity() {
        try {
            adTitle = basePage.getTitle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adTitle.equals("TestEditAd_RPS_SC Ad");
    }

}




