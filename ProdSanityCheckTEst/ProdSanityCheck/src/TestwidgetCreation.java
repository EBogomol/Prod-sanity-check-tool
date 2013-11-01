import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TestwidgetCreation {
    public WebDriver webdriver;
    public WebElement settingModule;

    ConfigsProperties configs = ConfigsProperties.getInstance();

    Report reportCreator = new Report();

    public TestwidgetCreation(WebDriver driver){
        webdriver = driver;
    }
    public void checkAbilityToCreateWidget() throws InterruptedException, IOException {
            Thread.sleep(10);
            settingModule = webdriver.findElement(By.id("properties"));

            if (settingModule.isDisplayed()){
                reportCreator.write("Widget entity is successfully created", configs.FileReportLocation, configs.FileReporName);
            }
            else{
                reportCreator.write("widget entity is unsuccessfully created", configs.FileReportLocation, configs.FileReporName);
            }

        }
    }


