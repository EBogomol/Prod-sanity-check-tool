package com.oggi.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.PasswordAuthentication;

public class TestSchemaEntity extends EntityCreationPage {
    BasePage basePage = new BasePage();
    SchemaEntityCreationPage schemaEntityCreationPage = new SchemaEntityCreationPage();
    LoginPage loginPage = new LoginPage();

    @Test (priority = 1)
    public void schemaEntityIsCreated() {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("Schema");
        schemaEntityCreationPage.createSchemaEntity();
        Assert.assertTrue(schemaEntityCreationPage.checkAbilityToCreateSchemaEntity(), "Schema entity can't be created");
    }
    @Test (priority = 2)
    public void schemaEntityIsEdited() {
        loginPage.loginToSystem(Login,Password);
        openEditPage(SchemaEntityCreationPage.schemaEntityID, "Schema");
        schemaEntityCreationPage.clearSchemaElements();
        schemaEntityCreationPage.addButtonsToSchema(2);
        changeTitle("TestEditSchema_RPS_SC");
        schemaEntityCreationPage.fillSchemaElement();
        clickSubmitButton();
        Assert.assertTrue(schemaEntityCreationPage.checkAbilityToEditSchemaEntity(), "Schema can't be edited");
    }
}
