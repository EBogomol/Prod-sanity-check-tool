import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TEstBaseWidgetCreation {
    public WebDriver webdriver;
    public WebElement settingModule;

    ConfigsProperties configs = ConfigsProperties.getInstance();

    Report reportCreator = new Report();

    public TEstBaseWidgetCreation(WebDriver driver){
        webdriver = driver;
    }
    public void checkabilityToCreateBW() throws InterruptedException, IOException {
          Thread.sleep(7);
        settingModule = webdriver.findElement(By.id("properties"));

        if (settingModule.isDisplayed()) {
            reportCreator.write("BaseWidget entity is successfully created", configs.FileReportLocation, configs.FileReporName);
        } else {
            reportCreator.write("BaseWidget entity is unsuccessfully created", configs.FileReportLocation, configs.FileReporName);
        }


    }
}
