package com.oggi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestDeleteEntities extends EntityCreationPage {
    Map<String, String> entities = new LinkedHashMap<String, String>();


    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();


    @Test(priority = 1)
    public void usedEntityIsNotDeleted() {
        loginPage.loginToSystem(Login, Password);
        entities.put(AdCreationPage.adExternalEntitylD, "Ad");
        Assert.assertFalse(basePage.deleteUsedEntity(entities));
        entities.clear();
    }

    @Test(priority = 2)
    public void entitiesAreDeleted() {
        entities.put(PlayListEntityCreation.playListEntityID,"Playlist");
        entities.put(AdListCreationPage.adlistID, "AdList");
        entities.put(AdCreationPage.adUploadEntityID, "Ad");
        entities.put(AdCreationPage.adExternalEntitylD, "Ad");
        entities.put(AdCreationPage.adSWFEntitylD, "Ad");
        entities.put(AdCreationPage.adXMLEntitylD, "Ad");
        entities.put(SchemaEntityCreationPage.schemaEntityID, "Schema");
        entities.put(BaseWidgetCreationPage.bwID,"BaseWidget");
        entities.put(WidgetCreationPage.widgetID,"Widget");




        loginPage.loginToSystem(Login, Password);
        boolean notUsedEntityCanBeDeleted = basePage.deleteEntity(entities);
        if (notUsedEntityCanBeDeleted = true)
            Assert.assertTrue(basePage.checkAbilityToDeleteEntity(entities), "Can not delete entities");
        else Assert.fail();
    }

}
