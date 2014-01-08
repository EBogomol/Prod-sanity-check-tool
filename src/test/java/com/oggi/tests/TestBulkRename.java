package com.oggi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBulkRename extends EntityCreationPage{
    LoginPage loginPage = new LoginPage();
    BulkRenamePage bulkRenamePage = new BulkRenamePage();

    @Test
    public void bulkRenameWorksOK(){
        loginPage.loginToSystem(Login,Password);
        driver.get("http://manager.rm.collective.com/main/BulkRename");
        bulkRenamePage.performBulkRename();
        Assert.assertTrue(bulkRenamePage.checkBulkRenameFuntion(),"Bulk rename doesn't work");
    }
}
