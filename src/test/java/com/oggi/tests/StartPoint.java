package com.oggi.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StartPoint extends ConfigsProperties {
    static FirefoxDriver driver;
    public WebElement settingModule;


    @BeforeMethod
    public void webDriverInitialization() {

        ConfigsProperties configs = ConfigsProperties.getInstance();

        String file = new File("").getAbsolutePath().concat("\\resources\\file.txt");


        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(LinkToPortal);

    }

    @AfterMethod
    public void closeWebDriver() {
        driver.quit();

    }
}









