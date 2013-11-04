import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TestwidgetCreation extends BasePage{

    public WebElement settingModule;

    ConfigsProperties configs = ConfigsProperties.getInstance();

    Report reportCreator = new Report();

    public TestwidgetCreation(WebDriver driver){
        super(driver);
    }
    public void checkAbilityToCreateWidget() throws InterruptedException, IOException {
           waitForPageLoaded();
            settingModule = webdriver.findElement(By.id("properties"));

            if (settingModule.isDisplayed()){
                reportCreator.write("Widget entity is successfully created", configs.FileReportLocation, configs.FileReporName);
            }
            else{
                reportCreator.write("widget entity is unsuccessfully created", configs.FileReportLocation, configs.FileReporName);
            }

        }
    }


