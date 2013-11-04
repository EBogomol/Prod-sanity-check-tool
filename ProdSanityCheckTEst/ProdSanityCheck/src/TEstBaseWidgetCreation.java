import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TestBaseWidgetCreation extends BasePage{

    public WebElement settingModule;
    Logger logger = LogManager.getLogger(TestBaseWidgetCreation.class.getName());

    public TestBaseWidgetCreation(WebDriver driver){
        super(driver);
    }
    public void checkabilityToCreateBW() throws InterruptedException, IOException {
         waitForPageLoaded();
        settingModule = webdriver.findElement(By.id("properties"));

        if (settingModule.isDisplayed()) {
            logger.info("BaseWidget entity is successfully created");
        } else {
            logger.info("BaseWidget entity is unsuccessfully created");
        }


    }
}
