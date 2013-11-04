import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TestVideoEntityCreation extends BasePage{

    private WebElement settingModule;
    Logger logger = LogManager.getLogger(TestBaseWidgetCreation.class.getName());

    public TestVideoEntityCreation(WebDriver driver){
        super(driver);
    }

    public void checkAbilityToCreateVideo() throws IOException, InterruptedException {

        waitForPageLoaded();
        settingModule = webdriver.findElement(By.id("properties"));

        if (settingModule.isDisplayed()){
            logger.info("Video entity is successfully created");
        }
        else{
            logger.info("Video entity is unsuccessfully created");
        }

    }
}