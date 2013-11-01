import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestVideoEntityCreation {
    private WebDriver webdriver;
    private WebElement settingModule;

    ConfigsProperties configs = ConfigsProperties.getInstance();

    Report reportCreator = new Report();

    public TestVideoEntityCreation(WebDriver driver){
        webdriver = driver;
    }

    public void checkAbilityToCreateVideo() throws IOException, InterruptedException {

        Thread.sleep(7);
        settingModule = webdriver.findElement(By.id("properties"));

        if (settingModule.isDisplayed()){
           reportCreator.write("Video entity is successfully created", configs.FileReportLocation, configs.FileReporName);
        }
        else{
            reportCreator.write("Video entity is unsuccessfully created", configs.FileReportLocation, configs.FileReporName);
        }

    }
}