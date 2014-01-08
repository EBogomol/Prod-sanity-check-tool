package com.oggi.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class StartPoint extends ConfigsProperties {
    static FirefoxDriver driver;
    public WebElement settingModule;


    @BeforeMethod
    public void webDriverInitialization() {

        ConfigsProperties configs = ConfigsProperties.getInstance();
        FirefoxProfile profile = new FirefoxProfile();
        getResources();
        profile.setPreference("browser.download.folderList",2);
        profile.setPreference("browser.download.dir", pathToResourcesFolder);
        profile.setPreference("dom.disable_open_during_load", false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(LinkToPortal);

    }

    @AfterMethod
    public void closeWebDriver() {
        driver.quit();

    }
}









