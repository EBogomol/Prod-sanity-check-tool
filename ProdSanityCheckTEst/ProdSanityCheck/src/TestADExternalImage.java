import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestADExternalImage  extends BasePage {
    private WebElement settingModule;
    Logger logger = LogManager.getLogger(TestADExternalImage.class.getName());

    public TestADExternalImage(WebDriver driver){
        super(driver);
    }

    public void checkAbilityToCreateAd() throws IOException, InterruptedException {
        waitForPageLoaded();
        settingModule = webdriver.findElement(By.id("properties"));

        if (settingModule.isDisplayed()){
            logger.info("External AD entity is successfully created");
        }
        else{
            logger.info("External AD entity is unsuccessfully created");
        }



    }


}
